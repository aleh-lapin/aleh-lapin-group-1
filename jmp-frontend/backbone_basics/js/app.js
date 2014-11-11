(function init(){
	app = {};
	app.models = {};
	app.views = {};
	app.collections = {};
	app.routers = {};
	app.GlobalEvent = {};
	_.extend(app.GlobalEvent, Backbone.Events);
	Backbone.emulateHTTP = true;
	Backbone.emulateJSON = true;
})();

app.views.BookmarkListContainerView = Backbone.View.extend({
	el: $("#bookmarkListContainer > h2"),
	initialize:function(){
		var that = this;
		this.listenTo(app.GlobalEvent, "filterBookmark", function(tag){
			that.$el.find("#bookmarkTagFilter").text(tag);
		});
	},
	events:{
		"click #clearFilter" : "clearFilter"
	},
	clearFilter: function() {
		app.GlobalEvent.trigger("resetBookmark", this, "reset");
		this.$el.find("#bookmarkTagFilter").text("None");
		return false;
	}
});


app.models.TagModel = Backbone.Model.extend({
	defaults:{
		id_bookmark: new Number(-1),
		tag: "",
	},
	initialize: function(){
		//this.on
	},
	urlRoot:"http://localhost/backbone_basics/api/Bookmark.php"
});

app.collections.TagListCollection = Backbone.Collection.extend({
	model: app.models.TagModel,
	url: "http://localhost/backbone_basics/api/TagList.php",
	comparator: function(tag){
		return tag.get("id_bookmark");
	}
});

app.models.BookmarkModel = Backbone.Model.extend({
	validate: function(attrs){
		if (attrs.url == undefined || attrs.url == "") {
			return "Empty url parameter. Please, specify correct url.";
		} 
		if (attrs.title == undefined || attrs.title == "") {
			return "Empty title parameter. Please, specify non-empty title.";
		}
		if (attrs.tags == undefined || attrs.tags.length == 0) {
			return "Empty tags parameter. Please, specify comma separated list of tags.";
		}
	},
	defaults:{
		id: new Number(-1),
		url: encodeURI("http://application.com"),
		title: "",
		tags: new Array()
	},
	initialize:function(){
		var id = parseInt(this.get("id"));
		var tagSet = new app.collections.TagListCollection();
		var callback = function(arg){
			return function(list){
				var temp = new Array();
				for(var i = 0, size = list.length; i < size; i++) {
					temp.push(list.at(i));
				}
				arg.set({tags : temp});
			}
		}(this);
		if (id > 0) {
			tagSet.fetch({
				data : {"id_bookmark" : id},
				success: callback,
				error: function(){ alert("Error!!!"); }
			});					
		}
		callback = null;
		//this.tags.add(tagSet);
		//alert("tags " + this.tags.length);
		this.on("invalid", function(model, err){
		//alert(err);
			app.GlobalEvent.trigger("invalidbookmark", err);
		});
	},
	urlRoot:"http://localhost/backbone_basics/api/Bookmark.php"
});

app.models.TagCountModel = Backbone.Model.extend({
	defaults:{
		count: new Number(-1),
		tag : ""
	},
	init:{
		//this.on
	},
	urlRoot:"http://localhost/backbone_basics/api/Bookmark.php"
});


app.collections.TagCountListCollection = Backbone.Collection.extend({
	model: app.models.TagCountModel,
	url: "http://localhost/backbone_basics/api/TagCountList.php",
	comparator: function(tagcount){
		return tagcount.get("count");
	}
});

app.collections.BookmarkListCollection = Backbone.Collection.extend({
	model: app.models.BookmarkModel,
	url: "http://localhost/backbone_basics/api/BookmarkList.php",
	comparator: function(bmark){
		return bmark.get("id");
	}
});

app.views.TagCountListView = Backbone.View.extend({
	el: $("#tagCountList"),
	router: {},
	views: new Array(),
	initialize : function(){
	this.router = new app.routers.Router();
		this.listenTo(app.GlobalEvent, "addTag", this.addTag);
		this.refresh();
	},
	refresh : function(){
		var element = this.$el;
		that = this;
		this.model.fetch({
			success: function(list){ 
				for(var i = 0; i < list.length; i++) {
					var bookMarkView = new app.views.TagCountView({model:list.at(i)});
					bookMarkView.setRouter(that.router);
					that.views.push({key: bookMarkView.model.get("tag"), value:bookMarkView});
					bookMarkView.render();
					element.append((bookMarkView).$el);
				}
			},
			error: function(){ alert(111); }
		});
	},
	render: function(){
		this.$e.html(_.template(this.template, this.model.toJSON()));
		return this;
	},
	addTag: function(tag) {
		if (this.model.findWhere({"tag": tag.get("tag")})) {
			var currView = this.views.filter(function(el, index, arr){
				if (el.key == tag.get("tag")) {
					return true;
				}
				return false;
			});
			if (currView.length > 0) {
				var prevCount = parseInt(currView[0].value.model.get("count"));
				currView[0].value.model.set({count:++prevCount});
				currView[0].value.render();
			}
			//alert(true);
		} else if (!!tag.get("tag")) {
			var newModel = new app.models.TagCountModel({count:1, tag:tag.get("tag")});
			this.model.add(newModel);
			var bookMarkView = new app.views.TagCountView({model:newModel});
			bookMarkView.setRouter(this.router);
			this.views.push({key: tag.get("tag"), value:bookMarkView});
			bookMarkView.render();
			this.$el.append((bookMarkView).$el);
			//alert(false);
		}
	}
});

app.views.TagCountView = Backbone.View.extend({
	router: {},
	setRouter : function(r){
		this.router = r;
	},
	initialize: function(){
		var that = this;
		this.$el.bind("click", function(e){
				e.preventDefault();
				var url = "filter/"+that.model.get("tag");
				that.router.navigate(url, {trigger: true, replace: true});
				return false;
			});
	},
	tagName: "li",
	template: "<a class=\"tag-link\" name=\"<%=tag%>\" href=\"#\"><%=tag %>(<%= count%>)</a>",
	render: function(){		
		this.$el.html(_.template(this.template, this.model.toJSON()));
		return this;
	}
});

app.views.BookmarkView = Backbone.View.extend({
	tagName: "li",
	template: "<div class=\"nav\" >" + 
		"<button id=\"btnEdit\" class=\"btn btn-warning\">Edit</button>" +
		"<button id=\"btnDelete\" class=\"btn btn-danger\">Delete</button><%=url%> | <%=title%>" + 
		"</div>",
	render: function(){
		this.$el.html(_.template(this.template, this.model.toJSON()));
		return this;
	},
	events : {
		"click #btnEdit" : "editBookmark",
		"click #btnDelete" : "deleteBookmark"
	},
	editBookmark : function(e) {
		app.GlobalEvent.trigger("editBookmark", this, "edit");
	},
	deleteBookmark : function(e) {
		app.GlobalEvent.trigger("deleteBookmark", this, "delete");
	}
});

app.views.BookmarkListView = Backbone.View.extend({
	el: $("#bookmarkList"),
	views: new Array(),
	render: function(){
		this.show();
		return this;
	},
	initialize: function(){
		that = this;
		//this.listenTo(this.model, "change", this.render);
		this.listenTo(app.GlobalEvent, "saveBookmark", this.refresh);
		this.listenTo(app.GlobalEvent, "deleteBookmark", this.refresh);
		this.listenTo(app.GlobalEvent, "refreshBookmark", this.refresh);
		this.listenTo(app.GlobalEvent, "filterBookmark", this.refresh); 
		this.listenTo(app.GlobalEvent, "resetBookmark", this.refresh);
		app.GlobalEvent.on("deleteBookmark", this.refresh, this);
		//this.model.on("add", function(model, collection, opts){
			//that.refresh(model);
		//});
		//this.show();
	},
	show: function(){
		var that = this;
		var element = this.el;
		var	viewSet	= new Array();;
		this.model.fetch({
			success: function(list){
				for(var i = 0; i < list.length; i++) {
					var bookMarkView = new app.views.BookmarkView({model:list.at(i)});
					var propertyName = list.at(i).cid;					
					that.views.push({key:propertyName, value: bookMarkView});
					bookMarkView.render();
					element.appendChild((bookMarkView).el);
				}
			},
			error: function(){ alert("Error!!!"); }
		});
		//this.views = this.views.concat(viewSet);
		//alert(viewSet.length);
	},
	getViewByCid: function(cid){
		var view = null;
		for(var i = 0, size = this.views.length; i < size; i++){
			view = this.views[i];
			if ((view.key != undefined || view.key != "")
				&& view.key == cid) {
				break;
			}
		}
		return view.value;
	},
	refresh : function(){
		var event = arguments[1];
		var m = arguments[0];
		switch(event) {
			case "save":
				var bookMarkView = new app.views.BookmarkView({model:m});
				this.views.push({key:m.cid, value: bookMarkView});
				this.model.add(m);
				(bookMarkView).$el.appendTo(this.$el);
				bookMarkView.render();
				break;
			case "delete":
				this.model.remove(m.model);
				m.model.get("tags").splice(0, m.model.get("tags").length);
				m.$el.remove();
				m.remove();
				break;
			case "refresh":
				m.render();
				break;
			case "filter":		
				this.views.forEach(function(el, index, arr){
					var isPresent = el.value.model.get("tags").some(function(e, i, a){						
						return (e.get("tag") == m);
					});
					if (isPresent) {
						el.value.$el.show();
					} else {
						el.value.$el.hide();
					}
				});
				break;
			case "reset":
				this.views.forEach(function(el, index, arr){
					el.value.$el.show();
				});
				break
		}
		
		return false;
	}
});

app.views.BookmarkFormView = Backbone.View.extend({
	el: $("#form"),
	map: [],
	isValid: true,
	currView: null,
	initialize: function(){
	var that = this;
		var innerMap = [];
		var errorMessage, error;
		this.listenTo(app.GlobalEvent, "editBookmark", this.editBookmark);
		this.$el.find("input").map(function(index, el){
			var name = $(this).attr("id");
			innerMap.push({key: name, value: el});
		});
		this.map = this.map.concat(innerMap);
		app.GlobalEvent.on("invalidbookmark", function(e){
			//alert(e);
			$(".alert-danger").show();
			$(".alert-danger > p").text(e);
			errorMessage = e;
			that.isValid = false;
		});
		/*this.$el.bind("submit", function(e){
		var target = e.target || e.srcElement;
			if (target.id = "btnSave") {
				saveBookmark();
			}
			return false;
		});*/
		//alert(this.map.length);
	},
	getValue:function(name){
		var element = null;
		for(var i = 0, size = this.map.length; i < size; i++){
			element = this.map[i];
			if (element.key == name && 
			(element.key != undefined || element.key != "")) {
				break;
			}
		}
		return element.value;
	},
    events : { 
		"click #btnSave":"saveBookmark",
		"click #btnClear":   "clearForm",
		"click #form" : "submit"
		//"click .button.delete": "destroy"
		},
    render : function(){
		return this;
	},
    renderAlert : function() {
		
	},
	editBookmark : function() {
		var element = null;
		var eventType = arguments[1];
		this.currView = arguments[0];
		for(var i = 0, size = this.map.length; i < size; i++){
			element = this.map[i];
			if (element.key != "tags"){
				element.value.value = this.currView.model.get(element.key);
			} else {
				var exp = /(?:["]tag["][:])["](\w+)["]/ig;
				//alert(this.currView.model.get("tags").length);
				var tags = JSON.stringify(this.currView.model.get("tags"), function(key, value){
					switch(key){
						case "tag":
							return value;
						case "id_bookmark":
							return undefined;
						default:
							return value;
					}
				});
				var stringArray = new Array();
				var matches = tags.replace(exp, function(match){
					stringArray.push(RegExp.$1)
					return RegExp.$1;
				}); 
				element.value.value = stringArray.join(",");
			}
		}
	},
    saveBookmark : function(e) {
		var newBookMark = (this.currView != null) ? this.currView.model : new app.models.BookmarkModel();
		var index = 0;
		this.isValid = true;
		if (this.model.length > 0){
			index = parseInt(this.model.at((this.model.length - 1)).get("id"));
		}
		index++;
		if (newBookMark.get("id") < 0)
			newBookMark.set({id: index});
		newBookMark.set({url: this.getValue("url").value});
		if (this.getValue("tags").value != undefined && this.getValue("title").value != "") {
			var newtags = this.getValue("tags").value.split(",");
			
			for(var i=0, size=newBookMark.get("tags").length;i<size;i++){
				newtags = newtags.filter(function(el, index, arr){
					if (newBookMark.get("tags")[i].get("tag") != el) {
						return true;
					}
					return false;
				});
			}
			
			if (newtags.length > 0) {
				for(var i=0, size=newtags.length;i<size;i++){
					var newTag = new app.models.TagModel(
						{id_bookmark: newBookMark.get("id"), tag:newtags[i]});
					newBookMark.get("tags").push(newTag);
					app.GlobalEvent.trigger("addTag", newTag, "add");
				}
			}
		}
		newBookMark.set({title: this.getValue("title").value}, {validate:true});
		if (this.isValid && !(!!this.model.where({id: newBookMark.get("id")}).toString())) {
			this.model.add(newBookMark);
			app.GlobalEvent.trigger("saveBookmark", newBookMark, "save");
			$(".alert-danger").hide();
		} else if (this.isValid) {
			app.GlobalEvent.trigger("refreshBookmark", this.currView, "refresh");
			$(".alert-danger").hide();
		}
		this.currView = null;
		return false;
	}, 
    clearForm : function(){
		this.currView = null;
		this.el.reset();
		return false;
	}
});



app.routers.Router = Backbone.Router.extend({
	initialize: function(){
		Backbone.history.start({
			pushState: false,
			root:"/index.html"
		});
	},
	_loadBookmarkListCollection: function(){
		
	},
	_loadTagCountListCollection: function(){
		
	},
	defaultRoute : function(){
		
	},
	bookmarkFilter : function(tag){
		app.GlobalEvent.trigger("filterBookmark", tag, "filter");
	},
	routes: {
		"bookmark/:id" : "_loadBookmarkListCollection",
		"filter/:tag" : "bookmarkFilter",
		"*other" : "defaultRoute"
	}
});

//var bookMarkModel = new 




var bookmarks = new app.collections.BookmarkListCollection([{}]);
var bookMarkList = new app.views.BookmarkListView({model:bookmarks});
bookMarkList.render();
var bokmarkForm = new app.views.BookmarkFormView({model:bookmarks});
var filter = new app.views.BookmarkListContainerView({model:bookmarks});
//alert(bokmarkForm.map.length);




var tags = new app.collections.TagCountListCollection([{}]);
var tagkList = new app.views.TagCountListView({model:tags});
	//bookMarkList.render();
/*
var bookmark = new app.models.BookmarkModel();

bookmark.fetch({
	data: {"id": "1"},
	success: function(model){ alert( model.get("url"));},
	error: function(e){ alert(111); }
	});
	
	
	alert(bookmark.isNew
	
	*/
	
package org.shop;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.shop.api.ItemService;
import org.shop.api.OrderService;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.data.Item;
import org.shop.data.Order;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.shop.data.Seller;
import org.shop.data.State;
import org.shop.data.User;
import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.access.BootstrapException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

	private static final Logger LOG = Logger.getLogger(ShopLauncher.class);

	private static final class ApplicationContextLoader {

		private ApplicationContext applicationContext;
		
		private static final String COMMON_CONTEXT_PATH = "classpath:/commons-ctx.xml";
		
		private static final String COMMON_CONTEXT_NAME = "commonContext";
		
		public ApplicationContextLoader() {
			try {

		        BeanFactoryLocator locator = ContextSingletonBeanFactoryLocator.getInstance(COMMON_CONTEXT_PATH);
		        BeanFactoryReference contextRef = locator.useBeanFactory(COMMON_CONTEXT_NAME);
		        applicationContext = (ApplicationContext) contextRef.getFactory();
		    } catch (BootstrapException e) {
		    	LOG.error("Couldn`t initialize application context", e);
		        applicationContext = null;
		    }
	        LOG.info("Initialize common applicationContext: " + applicationContext);
		}

		public ApplicationContext getApplicationContext() {
			return applicationContext;
		}
				
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		ApplicationContextLoader loader = new ApplicationContextLoader();
		ApplicationContext applicationContext = loader.getApplicationContext();
		DataInitializer dataInitializer = applicationContext.getBean(DataInitializer.class);
		OrderService orderService = applicationContext.getBean(OrderService.class);
				
		Long orderId = orderService.createOrder(createUser(), createItem());
		LOG.info("Order id: " + orderId);
		Order order = orderService.getOrderById(orderId);
		LOG.info("Order : " + order);
		
		ItemService itemService = applicationContext.getBean(ItemService.class);
		
		Long itemId = itemService.createItem(createItem());
		LOG.info("Item id: " + itemId);
		List<Item> items = itemService.getItemsByOrderId(itemId);
		for(Item item : items)
			LOG.info("Item" + item);
		
		ProductService productService = applicationContext.getBean(ProductService.class);
		
		Long productId = productService.createProduct(createProduct());
		LOG.info("Product id: " + itemId);
		Product product = productService.getProductById(productId);
		LOG.info("Product : " + product);
		
		SellerService sellerService = applicationContext.getBean(SellerService.class);
		sellerService.importSellers(new ArrayList<Seller>(){
			{
				add(createSeller());
			}
		});
		List<Seller> sellers = sellerService.getSellers();
		for(Seller seller : sellers)
			LOG.info("Seller" + seller);
		
		ProposalService proposalService = applicationContext.getBean(ProposalService.class);
		
		Long proposalID = proposalService.createProposal(3L, 2L, 20.0D);
		LOG.info("Proposal id: " + proposalID);
		
		List<Proposal> proposals = proposalService.getProposalsByProductId(2L);
		for(Proposal proposal : proposals) {
			LOG.info("Proposal" + proposal);
			proposalService.activateProposal(proposal.getId());
			LOG.info("Proposal" + proposal);
		}
	}
	
	private static Seller createSeller() {
		Seller seller = new Seller();
		seller.setId(1L);
		seller.setName("Seller");
		return seller;
	}
	
	private static Proposal createProposal() {
		Proposal proposal = new Proposal();
		proposal.setId(1L);
		proposal.setPrice(200.0D);
		proposal.setProduct(createProduct());
		proposal.setSeller(createSeller());
		proposal.setState(State.NOT_ACTIVE_PROPOSAL);
		return proposal;
	}
	
	private static User createUser() {
		User user = new User();
		user.setId(10L);
		user.setUsername("Patrick");
		return user;
	}
	
	private static Product createProduct() {
		Product product = new Product();
		product.setId(1L);
		product.setName("Product");
		product.setDescription("Default product description");
		return product;
	}
	
	private static Order createOrder() {
		Order order = new Order();
		order.setCreatedDate(new Date());
		order.setUser(createUser());
		return order;
	}
	
	private static Item createItem() {
		Item item = new Item();
		item.setId(1L);
		item.setPrice(20.0D);
		item.setProduct(createProduct());
		item.setOrder(createOrder());
		return item;
	}
}

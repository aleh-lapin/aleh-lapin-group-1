package jmp.module11.mvc.mvc;

import java.util.List;
import javax.validation.Valid;
import jmp.module11.mvc.domain.Account;
import jmp.module11.mvc.domain.ExchangerType;
import jmp.module11.mvc.rest.client.AccountRestApiClient;
import jmp.module11.mvc.rest.client.Client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class AccountController
{

    
    @Autowired
    private Client client;

    @RequestMapping(method=RequestMethod.GET)
    public String displaySortedMembers(Model model)
    {
        model.addAttribute("newAccount", new Account());
        //model.addAttribute("members", memberDao.findAllOrderedByName());
        return "accounts/create";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String updateAccount(@Valid @ModelAttribute("newAccount") Account newAccount, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	client.updateAccount(newAccount);
            return "redirect:/";
        }
        else {
            model.addAttribute("accounts", client.getAccounts());
            return "accounts/list";
        }
    }

    @RequestMapping(params = "form", method=RequestMethod.POST)
    public String registerNewAccount(@Valid @ModelAttribute("newAccount") Account newAccount, BindingResult result, Model model)
    {
        if (!result.hasErrors()) {
        	client.createAccount(newAccount);
            return "redirect:/";
        }
        else {
            model.addAttribute("accounts", client.getAccounts());
            return "accounts/list";
        }
    }
    
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
		Account account = new Account();
        uiModel.addAttribute("newAccount", account);
        return "accounts/create";
    }
	
	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Integer id, Model uiModel) {
        uiModel.addAttribute("newAccount", client.getAccount(id));
        return "accounts/update";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model uiModel) {
		List<Account> accounts = client.getAccounts();
		uiModel.addAttribute("accounts", accounts);
		return "accounts/list";
	}
	
	@RequestMapping(params = "form", value="exchanger", method = RequestMethod.GET)
	public String getExchanger(Model uiModel) {
		ExchangerType exchanger = client.getExchanger();
		uiModel.addAttribute("newExchanger", exchanger);
		return "accounts/exchanger";
	}
	
	@RequestMapping(params = "form", value="exchanger", method = RequestMethod.POST)
	public String updateExchanger(@Valid @ModelAttribute("newExchanger") ExchangerType newExchanger, BindingResult result, Model uiModel) {
		if (!result.hasErrors()) {
			client.updateExchanger(newExchanger);
			uiModel.addAttribute("accounts", client.getAccounts());
			return "accounts/list";
		} else {
			return "accounts/exchanger";
		}
	}

	public Client getClient() {
		return client;
	}

	public void setClient(AccountRestApiClient client) {
		this.client = client;
	}
		
}

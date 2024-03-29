package com.application.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.shopping.model.Product;
import com.application.shopping.model.ShoppingCart;
import com.application.shopping.model.User;
import com.application.shopping.repository.ProductRepository;
import com.application.shopping.repository.ShoppingCartRepository;
import com.application.shopping.repository.UserRepository;
import com.application.shopping.service.addToShoppingCart;

@RestController // This means that this class is a Controller
@RequestMapping(path="/shopping") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  @Autowired
  private ShoppingCartRepository scRepo;
  @Autowired
  private ProductRepository prodRepo;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }
  
  @PostMapping(path= "/addsc", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String addShoppingCart (@RequestBody ShoppingCart sc) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  addToShoppingCart adsc=new addToShoppingCart();
	  adsc.setProdRepo(prodRepo);
	  adsc.setScRepo(scRepo);
	  adsc.addShoppingCart(sc);
    return "Saved";
  }
  
  @PostMapping(path= "/updatesc", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String updateShoppingCart (@RequestBody ShoppingCart sc) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  addToShoppingCart adsc=new addToShoppingCart();
	  adsc.setProdRepo(prodRepo);
	  adsc.setScRepo(scRepo);
	  adsc.updateShoppingCart(sc);
    return "Saved";
  }
  
  @PostMapping(path= "/checkoutsc", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String checkoutShoppingCart (@RequestBody ShoppingCart sc) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  addToShoppingCart adsc=new addToShoppingCart();
	  adsc.setProdRepo(prodRepo);
	  adsc.setScRepo(scRepo);
	  adsc.checkoutShoppingCart(sc);
    return "CheckedOut";
  }
  
  @PostMapping(path= "/deletesc", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String deleteShoppingCart (@RequestBody ShoppingCart sc) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  addToShoppingCart adsc=new addToShoppingCart();
	  adsc.setProdRepo(prodRepo);
	  adsc.setScRepo(scRepo);
	  scRepo.deleteById(sc.getId());
    return "Deleted";
  }
  
  
  @PostMapping(path= "/addproduct", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String addProduct (@RequestBody Product prod) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  prodRepo.save(prod);
    return "Saved";
  }
  
  @PostMapping(path= "/deleteproduct", consumes = "application/json", produces = "application/json") // Map ONLY POST Requests
  public @ResponseBody String deleteProduct (@RequestBody Product prod) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
	  prodRepo.deleteById(prod.getId());
    return "Deleted";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
  
  @GetMapping(path="/allprod")
  public @ResponseBody Iterable<Product> getAllProduct() {
    // This returns a JSON or XML with the users
    return prodRepo.findAll();
  }
}
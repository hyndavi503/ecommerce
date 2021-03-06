package ecommerce.webapplication;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.webdemo.dao.CartDao;
import ecommerce.webdemo.dao.CartItemIdDao;
import ecommerce.webdemo.dao.CartItemsDao;
import ecommerce.webdemo.dao.CustomerDao;
import ecommerce.webdemo.dao.NoOfProductsDao;
import ecommerce.webdemo.dao.ProductDao;
import ecommerce.webdemo.daoimpl.CartItemsDaoImpl;
import ecommerce.webdemo.model.Cart;
import ecommerce.webdemo.model.CartItemId;
import ecommerce.webdemo.model.CartItems;
import ecommerce.webdemo.model.Customer;
import ecommerce.webdemo.model.NoOfProducts;
import ecommerce.webdemo.model.Products;
@Controller
public class CartController {

	@Autowired
	private NoOfProductsDao noOfProductsDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private CartItems cartItems;

	@Autowired
	private Customer customer;

	@Autowired
	private CartItemsDao cartItemsDao;

	@Autowired
	private CartItemId cartItemId;

	@Autowired
	private CartItemIdDao cartItemIdDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private Products products;
	
	@Autowired
	private Cart cart;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private NoOfProducts noOfProducts;

	@GetMapping("customer/addtocart")
	public String addToCart(Principal principal, HttpServletRequest request) {

		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int quantity = Integer.parseInt(request.getParameter("noOfProducts"));
		int unitprice = Integer.parseInt(productDao.getProduct(pid).getPrice());
		System.out.println(productDao.getProduct(pid).getPrice());
		Products products = productDao.getProduct(pid);
		customer = customerDao.getCustomerByEmail(principal.getName());

		if (checkAvailabilityOfProducts(pid, quantity) == true) {

			cart = cartDao.getCart(customer.getId());

			if (cart == null) {

				cart = new Cart();
				cartItems = new CartItems();
				List<CartItemId> cartItemIdList = new ArrayList<CartItemId>();
				List<CartItems> cartItemsList = new ArrayList<CartItems>();
				List<NoOfProducts> noOfProductsList = noOfProductsDao.getNoOfProducts(pid);

				for (int i = 0; i < quantity; i++) {

					cartItemId = new CartItemId();
					noOfProducts = new NoOfProducts();
					noOfProducts = noOfProductsList.get(i);
					noOfProducts.setSold(true);
					cartItemId.setNoOfProducts(noOfProducts);
					cartItemId.setCartItems(cartItems);
					cartItemIdList.add(cartItemId);
				}
				cartItems.setUnitPrice(unitprice);
				cartItems.setTotalPrice(unitprice * quantity);
				cartItems.setQuantity(quantity);
				cartItems.setCartItemIds(cartItemIdList);
				cartItems.setCart(cart);
				cartItemsList.add(cartItems);
				cart.setCartItems(cartItemsList);
				cart.setCustomer(customer);
				cart.setNetPrice(quantity * unitprice);
				cart.setNoOfItems(quantity);
				cartDao.addCart(cart);

				return "redirect:/customer/cart";

			} else {

				cartItems = checkIfProductAlreadyExists(pid, cart);

				if (cartItems != null) {

					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					cartItemsList = cart.getCartItems();
					int position = cartItemsList.indexOf(cartItems);
					List<NoOfProducts> noOfProductsList = noOfProductsDao.getNoOfProducts(pid);
					cartItemIdsList = cartItemIdDao.getAllCartItemId(cartItems.getCartItem_id());

					for (int i = 0; i < quantity; i++) {

						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = noOfProductsList.get(i);
						noOfProducts.setSold(true);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setCartItemIds(cartItemIdsList);
					cartItemsList.add(position, cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartDao.updateCart(cart);

					return "redirect:/customer/cart";
				} else {

					cartItems = new CartItems();
					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					List<NoOfProducts> numberOfProductsList = noOfProductsDao.getNoOfProducts(pid);
					for (int i = 0; i < quantity; i++) {

						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = numberOfProductsList.get(i);
						noOfProducts.setSold(true);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setUnitPrice(unitprice);
					cartItems.setTotalPrice(unitprice * quantity);
					cartItems.setQuantity(quantity);
					cartItems.setCartItemIds(cartItemIdsList);
					cartItems.setCart(cart);
					cartItemsList.add(cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartDao.updateCart(cart);
					return "redirect:/customer/cart";
				}

			}

		} else {

			return "redirect:/customer/customerpage";
		}

	}

	public CartItems checkIfProductAlreadyExists(int pid, Cart cart) {

		List<CartItems> cartItemsList = cart.getCartItems();
		for (CartItems items : cartItemsList) {
			if (items.getCartItemIds().get(0).getNoOfProducts().getProducts().getPid() == pid) {
				return items;
			}
		}
		return null;
	}

	public boolean checkAvailabilityOfProducts(int pid, int quantity) {

		if (noOfProductsDao.getNoOfProducts(pid).size() >= quantity) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("customer/cart")
	public String displayCart(Principal principal, HttpSession session, Model model) {
		Customer customer = customerDao.getCustomerByEmail(principal.getName());
		Cart cart = cartDao.getCart(customer.getId());

		model.addAttribute("cart", cart);
		return "cart";
	}

	
	/*@GetMapping("customer/cart")
	public String deleteCart(@PathVariable)
	{
		
	}*/
}


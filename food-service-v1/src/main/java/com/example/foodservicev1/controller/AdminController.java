package com.example.foodservicev1.controller;

import com.example.foodservicev1.entity.Admin;
import com.example.foodservicev1.entity.Customer;
import com.example.foodservicev1.entity.Restaurant;
import com.example.foodservicev1.service.AdminService;
import com.example.foodservicev1.service.CustomerService;
import com.example.foodservicev1.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@SessionAttributes({"saveResponse", "updateResponse", "deleteResponse", "loginResponse", "email"})
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestaurantService restaurantService;

    /////////////////////////// Homepage //////////////////////////////
    @GetMapping("/api/admin")
    public ModelAndView home(Model model) {
        // Set some value of attributes for modal appear
        model.addAttribute("saveResponse", -2);
        model.addAttribute("updateResponse", -2);
        model.addAttribute("deleteResponse", -2);
        model.addAttribute("loginResponse", -2);

        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        // Create the page
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");

        // Return home page
        return modelAndView;
    }

    /////////////////////////// Read //////////////////////////////
    // Page of Manage Administrators
    @GetMapping("/api/admin/admins")
    public ModelAndView manageAdminsPage(Model model) {
        // Set some value of attributes for modal appear
        model.addAttribute("saveResponse", -2);
        model.addAttribute("updateResponse", -2);
        model.addAttribute("deleteResponse", -2);
        model.addAttribute("loginResponse", -2);

        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("admins", adminService.findAll());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/find-admin");

        return modelAndView;
    }

    // Page of Manage Customers
    @GetMapping("/api/admin/customers")
    public ModelAndView manageCustomersPage(Model model) {
        // Set some value of attributes for modal appear
        model.addAttribute("saveResponse", -2);
        model.addAttribute("updateResponse", -2);
        model.addAttribute("deleteResponse", -2);
        model.addAttribute("loginResponse", -2);

        model.addAttribute("customers", customerService.findAll());

        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/find-customer");

        return modelAndView;
    }

    // Page of Manage Restaurants
    @GetMapping("/api/admin/restaurants")
    public ModelAndView manageRestaurantsPage(Model model) {
        // Set some value of attributes for modal appear
        model.addAttribute("saveResponse", -2);
        model.addAttribute("updateResponse", -2);
        model.addAttribute("deleteResponse", -2);
        model.addAttribute("loginResponse", -2);

        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("restaurants", restaurantService.findAll());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/find-restaurant");

        return modelAndView;
    }

    // Page of Create Administrators
    @GetMapping("/api/admin/create-admin")
    public ModelAndView createAdminPage(Model model) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        // Add object for form
        model.addAttribute("admin", new Admin());

        // Set up the modal message
        String modalId = "modal";
        String modalContent = "Create Admin successfully";
        if ((int) model.getAttribute("saveResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("saveResponse") == 0) {
            modalContent = "The email is existed";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/save-admin");

        // Return the page
        return modelAndView;
    }

    // Page of Update Administrators
    @GetMapping("/api/admin/update-admin/{email}")
    public ModelAndView updateAdminPage(Model model, @PathVariable String email) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("admin", adminService.findByEmail(email));
        String modalId = "modal";
        String modalContent = "Update Admin successfully";
        if ((int) model.getAttribute("updateResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("updateResponse") == 0) {
            modalContent = "Something wrong happen!";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/edit-admin");

        return modelAndView;
    }

    // Page of Create Customers
    @GetMapping("/api/admin/create-customer")
    public ModelAndView saveCustomerPage(Model model) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        // Add object for form
        model.addAttribute("customer", new Customer());

        // Set up the modal message
        String modalId = "modal";
        String modalContent = "Create Customer successfully";
        if ((int) model.getAttribute("saveResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("saveResponse") == 0) {
            modalContent = "The email is existed";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/save-customer");

        // Return the page
        return modelAndView;
    }

    // Page of Update Customer
    @GetMapping("/api/admin/update-customer/{email}")
    public ModelAndView updateCustomerPage(Model model, @PathVariable String email) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("customer", customerService.findByEmail(email));
        String modalId = "modal";
        String modalContent = "Update Customer successfully";
        if ((int) model.getAttribute("updateResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("updateResponse") == 0) {
            modalContent = "Something wrong happen!";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/edit-customer");

        return modelAndView;
    }

    // Page of Create Restaurant
    @GetMapping("/api/admin/create-restaurant")
    public ModelAndView saveRestaurantPage(Model model) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        // Add object for form
        model.addAttribute("restaurant", new Restaurant());

        // Set up the modal message
        String modalId = "modal";
        String modalContent = "Create Restaurant successfully";
        if ((int) model.getAttribute("saveResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("saveResponse") == 0) {
            modalContent = "The username is existed";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/save-restaurant");

        // Return the page
        return modelAndView;
    }

    // Page of Update Restaurant
    @GetMapping("/api/admin/update-restaurant/{username}")
    public ModelAndView updateRestaurantPage(Model model, @PathVariable String username) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("restaurant", restaurantService.findByUsername(username));
        String modalId = "modal";
        String modalContent = "Update Restaurant successfully";
        if ((int) model.getAttribute("updateResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("updateResponse") == 0) {
            modalContent = "Something wrong happen!";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/edit-restaurant");

        return modelAndView;
    }

    // Page of Login
    @GetMapping("/api/admin/login")
    public ModelAndView loginPage(Model model) {
        String modalContent = "Login successfully";
        String modalId = "modal";

        int response = -2;

        if (model.getAttribute("loginResponse") == null) {
            modalId = "notModal";
        } else {
            response = (int) model.getAttribute("loginResponse");
            if (response == -1) {
                modalContent = "The email does not exist!";
            } else if (response == 0) {
                modalContent = "Wrong password!";
            } else {
                if (model.getAttribute("email") != null) {
                    return new ModelAndView("redirect:/api/admin");
                } else {
                    modalId = "notModal";
                }
            }
            model.addAttribute("modalId", modalId);
            model.addAttribute("modalContent", modalContent);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/login");

        model.addAttribute("loginResponse", null);

        return modelAndView;
    }

    /////////////////////////// Create //////////////////////////////
    @PostMapping("/api/admin/admin")
    public ModelAndView save(Model model, @ModelAttribute Admin admin) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("admin", new Admin());
        model.addAttribute("saveResponse", adminService.save(admin));
        return new ModelAndView("redirect:/api/admin/create-admin");
    }

    @PostMapping("/api/admin/customer")
    public ModelAndView saveCustomer(Model model, @ModelAttribute Customer customer) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("customer", new Customer());
        model.addAttribute("saveResponse", customerService.save(customer));
        return new ModelAndView("redirect:/api/admin/create-customer");
    }

    @PostMapping("/api/admin/restaurant")
    public ModelAndView saveRestaurant(Model model, @ModelAttribute Restaurant restaurant) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("saveResponse", restaurantService.save(restaurant));
        return new ModelAndView("redirect:/api/admin/create-restaurant");
    }

    /////////////////////////// Update //////////////////////////////
    @PutMapping("/api/admin/admin")
    public ModelAndView updateAdmin(Model model, @ModelAttribute Admin admin) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("admin", new Admin());
        model.addAttribute("updateResponse", adminService.update(admin));
        return new ModelAndView("redirect:/api/admin/update-admin/" + admin.getEmail());
    }

    @PutMapping("/api/admin/customer")
    public ModelAndView updateCustomer(Model model, @ModelAttribute Customer customer) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("customer", new Customer());
        model.addAttribute("updateResponse", customerService.update(customer));
        return new ModelAndView("redirect:/api/admin/update-customer/" + customer.getEmail());
    }

    @PutMapping("/api/admin/restaurant")
    public ModelAndView updateRestaurant(Model model, @ModelAttribute Restaurant restaurant) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("updateResponse", restaurantService.update(restaurant));
        return new ModelAndView("redirect:/api/admin/update-restaurant/" + restaurant.getUsername());
    }

    /////////////////////////// Delete //////////////////////////////
    @DeleteMapping("api/admin/admin/{email}")
    public ModelAndView delete(Model model, @PathVariable String email, HttpSession httpsession, SessionStatus status) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("admin", new Admin());
        model.addAttribute("deleteResponse", adminService.delete(email));
        if (model.getAttribute("email").equals(email)) {
            /*Mark the current handler's session processing as complete, allowing for cleanup of
  session attributes.*/
            status.setComplete();
            /* Invalidates this session then unbinds any objects bound to it. */
            httpsession.invalidate();
            return new ModelAndView("redirect:/api/admin/login");
        }
        return new ModelAndView("redirect:/api/admin/admins");
    }

    @DeleteMapping("api/admin/customer/{email}")
    public ModelAndView deleteCustomer(Model model, @PathVariable String email,
                                       HttpSession httpsession, SessionStatus status) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("customer", new Customer());
        model.addAttribute("deleteResponse", customerService.delete(email));
        return new ModelAndView("redirect:/api/admin/customers");
    }

    @DeleteMapping("api/admin/restaurant/{username}")
    public ModelAndView deleteRestaurant(Model model, @PathVariable String username,
                                       HttpSession httpsession, SessionStatus status) {
        // Exit to login page if not login yet
        if (model.getAttribute("email") == null) {
            return new ModelAndView("redirect:/api/admin/login");
        }

        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("deleteResponse", restaurantService.delete(username));
        return new ModelAndView("redirect:/api/admin/restaurants");
    }

    /////////////////////////// Login //////////////////////////////
    @PostMapping("api/admin/login")
    public ModelAndView login(Model model, @RequestParam String email, @RequestParam String password) {
        model.addAttribute("admin", new Admin());

        int response = adminService.login(email, password);
        model.addAttribute("loginResponse", response);

        if (response == 1) {
            model.addAttribute("email", email);
            return new ModelAndView("redirect:/api/admin");
        }
        return new ModelAndView("redirect:/api/admin/login");
    }

    /////////////////////////// Logout //////////////////////////////
    @GetMapping("/api/admin/logout")
    public ModelAndView logout(Model model, HttpSession httpsession, SessionStatus status) {
        /*Mark the current handler's session processing as complete, allowing for cleanup of
  session attributes.*/
        status.setComplete();
        /* Invalidates this session then unbinds any objects bound to it. */
        httpsession.invalidate();
        return new ModelAndView("redirect:/api/admin/login");
    }

    // TODO: Upload picture
    // TODO: validator for dto
    // TODO: SHOW image in customer view food

}

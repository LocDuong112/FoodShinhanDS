package com.example.foodservicev1.controller;

import com.example.foodservicev1.entity.*;
import com.example.foodservicev1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"saveResponse", "updateResponse", "deleteResponse", "loginResponse", "username",
        "restaurantMessageList"})
@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private AIChatService aiChatService;

    /////////////////////////// Homepage //////////////////////////////
    @GetMapping("/api/restaurant")
    public ModelAndView home(Model model) {
        model.addAttribute("saveResponse", -2);
        model.addAttribute("updateResponse", -2);
        model.addAttribute("deleteResponse", -2);
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("username", (String) model.getAttribute("username"));
        model.addAttribute("foods", foodService.findByRestaurantUsername((String) model.getAttribute("username")));
        modelAndView.setViewName("restaurant/home");
        return modelAndView;
    }


    /////////////////////////// Read //////////////////////////////
    @GetMapping("/api/restaurant/login")
    public ModelAndView loginPage(Model model) {
        String modalContent = "Login successfully";
        String modalId = "modal";

        int response = -2;

        if (model.getAttribute("loginResponse") == null) {
            modalId = "notModal";
        } else {
            response = (int) model.getAttribute("loginResponse");
            if (response == -1) {
                modalContent = "The username does not exist!";
            } else if (response == 0) {
                modalContent = "Wrong password!";
            } else {
                if (model.getAttribute("username") != null) {
                    return new ModelAndView("redirect:/api/restaurant");
                } else {
                    modalId = "notModal";
                }
            }
            model.addAttribute("modalId", modalId);
            model.addAttribute("modalContent", modalContent);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/login");

        model.addAttribute("loginResponse", null);

        return modelAndView;
    }

    // Page of Create Restaurant (Register)
    @GetMapping("/api/restaurant/register")
    public ModelAndView saveRestaurantPage(Model model) {
        // Add object for form
        model.addAttribute("restaurant", new Restaurant());

        // Set up the modal message
        String modalId = "modal";
        String modalContent = "Create Restaurant successfully";
        if (model.getAttribute("saveResponse") == null) {
            modalId = "notModal";
        } else {
            if ((int) model.getAttribute("saveResponse") == -2) {
                modalId = "notModal";
            } else if ((int) model.getAttribute("saveResponse") == 0) {
                modalContent = "The username is existed";
            }
        }

        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/save-restaurant");

        // Return the page
        return modelAndView;
    }

    // Page of Update Restaurant (Profile)
    @GetMapping("/api/restaurant/profile")
    public ModelAndView updateRestaurantPage(Model model) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("restaurant", restaurantService.findByUsername((String) model.getAttribute("username")));
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
        modelAndView.setViewName("restaurant/profile");

        return modelAndView;
    }

    @GetMapping("/api/restaurant/create-food")
    public ModelAndView createFoodPage(Model model) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("food", new Food());
        String modalId = "modal";
        String modalContent = "Update Food successfully";
        if ((int) model.getAttribute("saveResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("saveResponse") == 0) {
            modalContent = "Something wrong happen!";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/create-food");

        return modelAndView;
    }

    @GetMapping("/api/restaurant/update-food/{id}")
    public ModelAndView updateFoodPage(Model model, @PathVariable String id) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("food", foodService.findById(id));
        String modalId = "modal";
        String modalContent = "Update Food successfully";
        if ((int) model.getAttribute("updateResponse") == -2) {
            modalId = "notModal";
        } else if ((int) model.getAttribute("updateResponse") == 0) {
            modalContent = "Something wrong happen!";
        }
        model.addAttribute("modalId", modalId);
        model.addAttribute("modalContent", modalContent);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/edit-food");

        return modelAndView;
    }

    @GetMapping("/api/restaurant/orders")
    public ModelAndView ordersPage(Model model) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("orders", serviceOrderService.find());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/orders");

        return modelAndView;
    }

    @GetMapping("/api/restaurant/order/{orderId}")
    public ModelAndView orderDetailPage(Model model, @PathVariable String orderId) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("orderID", orderId);
        model.addAttribute("orderDetailDtos", orderDetailService.findByOrderId(orderId));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/order-detail");

        return modelAndView;
    }

    @GetMapping("/api/restaurant/chat")
    public ModelAndView aiChatPage(Model model) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        List<Message> messageList = new ArrayList<Message>();
        if (model.getAttribute("restaurantMessageList") != null) {
            messageList = (List<Message>)model.getAttribute("restaurantMessageList");
        }
        model.addAttribute("restaurantMessageList", messageList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restaurant/ai-chat");

        return modelAndView;
    }


    /////////////////////////// Create //////////////////////////////
    @PostMapping("/api/restaurant/restaurant")
    public ModelAndView saveRestaurant(Model model, @ModelAttribute Restaurant restaurant) {
        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("saveResponse", restaurantService.save(restaurant));
        return new ModelAndView("redirect:/api/restaurant/register");
    }

    @PostMapping("/api/restaurant/food")
    public ModelAndView saveFood(Model model, @ModelAttribute Food food) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("food", new Food());
        food.setRestaurantUsername((String)model.getAttribute("username"));
        model.addAttribute("saveResponse", foodService.save(food));
        return new ModelAndView("redirect:/api/restaurant/create-food");
    }

    @PostMapping("/api/restaurant/chat/request")
    public ModelAndView restaurantAIChatResponse(Model model, @RequestParam String request) {
        List<Message> messageList = new ArrayList<Message>();
        if (model.getAttribute("restaurantMessageList") != null) {
            messageList = (List<Message>)model.getAttribute("restaurantMessageList");
        }

        Timestamp requestTime = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm | MMMM dd");
        String response = aiChatService.chatResponse(request);
        Timestamp responseTime = new Timestamp(System.currentTimeMillis());

        messageList.add(new Message(request, response, sdf.format(requestTime), sdf.format(responseTime)));

        // Add to session model attribute
        model.addAttribute("restaurantMessageList", messageList);

        return new ModelAndView("redirect:/api/restaurant/chat");
    }


    /////////////////////////// Update //////////////////////////////
    @PutMapping("/api/restaurant/restaurant")
    public ModelAndView updateCustomer(Model model, @ModelAttribute Restaurant restaurant) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("customer", new Restaurant());
        model.addAttribute("updateResponse", restaurantService.update(restaurant));
        return new ModelAndView("redirect:/api/restaurant/profile");
    }

    @PutMapping("/api/restaurant/food")
    public ModelAndView updateFood(Model model, @ModelAttribute Food food) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("food", new Food());
        model.addAttribute("updateResponse", foodService.update(food));
        return new ModelAndView("redirect:/api/restaurant/update-food/" + food.getId());
    }


    /////////////////////////// Delete //////////////////////////////
    @DeleteMapping("api/restaurant/restaurant/{username}")
    public ModelAndView delete(Model model, @PathVariable String username,
                               HttpSession httpsession, SessionStatus status) {
        if (model.getAttribute("username") == null) {
            return new ModelAndView("redirect:/api/restaurant/login");
        }

        model.addAttribute("restaurant", new Restaurant());
        model.addAttribute("deleteResponse", restaurantService.delete(username));
        status.setComplete();
        httpsession.invalidate();
        return new ModelAndView("redirect:/api/restaurant/login");
    }


    /////////////////////////// Login //////////////////////////////
    @PostMapping("api/restaurant/login")
    public ModelAndView login(Model model, @RequestParam String username, @RequestParam String password) {
        model.addAttribute("restaurant", new Restaurant());

        int response = restaurantService.login(username, password);
        model.addAttribute("loginResponse", response);

        if (response == 1) {
            model.addAttribute("username", username);
            return new ModelAndView("redirect:/api/restaurant");
        }
        return new ModelAndView("redirect:/api/restaurant/login");
    }

    /////////////////////////// Logout //////////////////////////////
    @GetMapping("/api/restaurant/logout")
    public ModelAndView logout(Model model, HttpSession httpsession, SessionStatus status) {
        status.setComplete();
        httpsession.invalidate();
        return new ModelAndView("redirect:/api/restaurant/login");
    }
}

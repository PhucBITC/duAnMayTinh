package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.OrderService;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserSevice;

@Controller
public class DashboardController {
    private final UserSevice userSevice;
    private final ProductService productService;
    private final OrderService orderService;

    public DashboardController(UserSevice userSevice, ProductService productService, OrderService orderService) {
        this.userSevice = userSevice;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/admin")
    public String getDashBoard(Model model) {
        model.addAttribute("countUser", this.userSevice.countUser());
        model.addAttribute("countProduct", this.userSevice.countProduct());
        model.addAttribute("countOrder", this.userSevice.countOrder());
        return "admin/dashboard/show";
    }

}

package ua.training.cruise_company_on_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.training.cruise_company_on_spring.dto.CruiseDTO;
import ua.training.cruise_company_on_spring.dto.CruiseOrderFormDTO;
import ua.training.cruise_company_on_spring.entity.Cruise;
import ua.training.cruise_company_on_spring.entity.Seaport;
import ua.training.cruise_company_on_spring.entity.User;
import ua.training.cruise_company_on_spring.service.OrderCruiseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/tourist")
public class TouristCruiseController {
    @Autowired
    private OrderCruiseService orderCruiseService;

    @GetMapping("/cruises")
    public String getAllPortsList(Model model,
                                  @PageableDefault(size = 6) Pageable pageable)  {
        Page<CruiseDTO> cruisesPage = orderCruiseService.allCruisesFromTodayPaginated( pageable);
        model.addAttribute("cruises", cruisesPage);

        int totalPages = cruisesPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "/tourist/cruises";
    }


    @GetMapping("/order/cruise/{cruise}")
    public String showCruiseOrderForm(@PathVariable Cruise cruise, Model model){
        List<Seaport> portsList = new ArrayList<>(cruise.getShip().getVisitingPorts());

        model.addAttribute("cruise", CruiseOrderFormDTO.builder()
                .cruiseId(cruise.getId())
                .routeNameEn(cruise.getShip().getRouteNameEn())
                .routeNameUkr(cruise.getShip().getRouteNameUkr())
                .portsList(portsList)
                .startingDate(cruise.getStartingDate())
                .finishingDate( cruise.getStartingDate().plusDays(cruise.getShip().getOneTripDurationDays()))
                .shipName(cruise.getShip().getName())
                .price(cruise.getPrice())
                .build());
        return "/tourist/order_cruise";
    }

    @PostMapping("/order/cruise/{cruiseId}")
    public String showCruiseOrderForm(@AuthenticationPrincipal User user,
                                      @PathVariable Long cruiseId,
                                      @RequestParam int quantity,
                                      Model model){
        try {
            orderCruiseService.bookCruise(user, cruiseId, quantity);
            return "redirect:/tourist/my_orders";
        }catch (TransactionSystemException transactionEx){
            return "redirect:/tourist/order/cruise/" + cruiseId + "?error";
        } catch (Exception ex){
            return "redirect:/tourist/order/cruise/" + cruiseId + "?exception=" + ex.getClass();
        }
    }


    @GetMapping("/cancel_order/{orderId}")
    public String cancelOrder(@PathVariable Long orderId){
        try {
            orderCruiseService.cancelBooking(orderId);
            return "redirect:/tourist/my_orders";
        }catch (TransactionSystemException transactionEx){
            return "redirect:/tourist/my_orders?error";
        } catch (Exception ex){
            return "redirect:/tourist/my_orders?exception=" + ex.getClass();
        }
    }
}

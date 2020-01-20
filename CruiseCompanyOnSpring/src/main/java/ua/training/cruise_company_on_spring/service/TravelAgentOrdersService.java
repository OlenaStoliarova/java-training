package ua.training.cruise_company_on_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.cruise_company_on_spring.dto.TravelAgentOrderDTO;
import ua.training.cruise_company_on_spring.entity.Excursion;
import ua.training.cruise_company_on_spring.entity.Extra;
import ua.training.cruise_company_on_spring.entity.Order;
import ua.training.cruise_company_on_spring.entity.OrderStatus;
import ua.training.cruise_company_on_spring.repository.ExtraRepository;
import ua.training.cruise_company_on_spring.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TravelAgentOrdersService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ExtraRepository extraRepository;


    public List<TravelAgentOrderDTO> allOrders() {
        return orderRepository.findAllByOrderByCreationDateDesc().stream().map(TravelAgentOrdersService::orderToDTO).collect(Collectors.toList());
    }

    public List<Extra> allBonusesForCruise(Long orderId) throws NoEntityFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NoEntityFoundException("There is no order with provided id (" + orderId + ")"));
        return new ArrayList<>(order.getCruise().getShip().getExtras());
    }

    @Transactional
    public void addBonusesToOrder(Long orderId, List<Long> bonusesIds) throws NoEntityFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NoEntityFoundException("There is no order with provided id (" + orderId + ")"));
        if( ! bonusesIds.isEmpty()){
            Set<Extra> extras = new HashSet<>( extraRepository.findAllById(bonusesIds));
            order.setFreeExtras(extras);
        }
        order.setStatus(OrderStatus.EXTRAS_ADDED);
        orderRepository.save(order);
    }


    static TravelAgentOrderDTO orderToDTO(Order order){
        TravelAgentOrderDTO result = TravelAgentOrderDTO.builder()
                .orderId(order.getId())
                .clientEmail( order.getUser().getEmail())
                .orderDate(order.getCreationDate())
                .quantity(order.getQuantity())
                .shipName( order.getCruise().getShip().getName())
                .cruiseStartingDate(order.getCruise().getStartingDate())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .build();

        if( !order.getExcursions().isEmpty()){
            Set<Excursion> excursions = order.getExcursions();
            StringBuilder excursionsEn = new StringBuilder();
            StringBuilder excursionsUkr = new StringBuilder();
            for( Excursion excursion: excursions){
                excursionsEn.append(excursion.getNameEn());
                excursionsEn.append(", ");
                excursionsUkr.append(excursion.getNameUkr());
                excursionsUkr.append(", ");
            }
            excursionsEn.replace( excursionsEn.lastIndexOf(","), excursionsEn.length(), "");
            excursionsUkr.replace( excursionsUkr.lastIndexOf(","), excursionsUkr.length(), "");
            result.setAddedExcursionsEn(excursionsEn.toString());
            result.setAddedExcursionsUkr(excursionsUkr.toString());
        } else if (order.getStatus().compareTo( OrderStatus.EXCURSIONS_ADDED) >= 0){
            result.setAddedExcursionsEn("-");
            result.setAddedExcursionsUkr("-");
        }

        if( !order.getFreeExtras().isEmpty()){
            Set<Extra> extras = order.getFreeExtras();
            StringBuilder extrasEn = new StringBuilder();
            StringBuilder extrasUkr = new StringBuilder();
            for( Extra bonus: extras){
                extrasEn.append( bonus.getNameEn());
                extrasEn.append(", ");
                extrasUkr.append( bonus.getNameUkr());
                extrasUkr.append(", ");
            }
            extrasEn.replace( extrasEn.lastIndexOf(","), extrasEn.length(), "");
            extrasUkr.replace( extrasUkr.lastIndexOf(","), extrasUkr.length(), "");
            result.setFreeExtrasEn(extrasEn.toString());
            result.setFreeExtrasUkr(extrasUkr.toString());
        } else if (order.getStatus() == OrderStatus.EXTRAS_ADDED){
            result.setFreeExtrasEn("-");
            result.setFreeExtrasUkr("-");
        }

        return result;
    }
}

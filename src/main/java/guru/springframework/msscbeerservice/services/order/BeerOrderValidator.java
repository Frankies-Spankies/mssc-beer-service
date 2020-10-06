package guru.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.events.BeerOrderDto;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrder){

        AtomicInteger beersNotFound = new AtomicInteger();

        beerOrder.getBeerOrderLines().forEach(orderline -> {
            if(beerRepository.findByUpc(orderline.getUpc()) == null){
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }

}

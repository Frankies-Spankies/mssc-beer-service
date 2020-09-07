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

    public Boolean validateOrder(BeerOrderDto beerOrderDto) {
        AtomicInteger beerNotFound = new AtomicInteger();
        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
            if (!beerRepository.existsById(beerOrderLineDto.getBeerId())) {
                beerNotFound.incrementAndGet();
            }
        });

        return beerNotFound.get()>0;
    }
}

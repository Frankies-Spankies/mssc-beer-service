package guru.sfg.common.events;

import guru.springframework.msscbeerservice.web.model.BeerDto;
import lombok.NoArgsConstructor;

//Jackson nescesita un constructor vacio
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{

    //Los constructores deben ser publicos
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}

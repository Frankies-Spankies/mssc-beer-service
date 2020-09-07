package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

//Jackson nescesita un constructor vacio
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent{

    //Los constructores deben ser publicos
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}

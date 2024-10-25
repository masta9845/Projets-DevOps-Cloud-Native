package com.example.Articfact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

    private List<cars> cars = new ArrayList<>();

    public HelloService() {
        cars.add(new cars("11AA22", "Ferrari", 100));
        cars.add(new cars("33BB44", "Tesla", 80));
        cars.add(new cars("55CC66", "BMW", 90));
        cars.add(new cars("45CC66", "Audi", 90));
    }

    @GetMapping("/")
    public String hello() {
        return "Bienvenue dans le service de location de voitures !";
    }

   /**  @GetMapping("/cars")
    public List<cars> listOfCars() {
        List<cars> availableCars = new ArrayList<>();
        for (cars car : cars) {
            if (!car.isRented()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    } */

    // Afficher les voitures 
    @GetMapping("/cars")
    public String listOfCars() {
        StringBuilder result = new StringBuilder();

        // Début du HTML avec du CSS intégré pour la mise en page en grille et les couleurs
        result.append("<html><head><style>")
            .append("body { font-family: Arial, sans-serif; background-color: #f4f4f9; }")
            .append(".car-container { display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 20px; width: 80%; margin: 20px auto; }")
            .append(".car { background-color: #ffffff; padding: 15px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center; }")
            .append(".car-header { font-size: 18px; font-weight: bold; color: #333; }")
            .append(".car-details { color: #555; }")
            .append(".price { color: #f05454; font-weight: bold; }")
            .append("</style></head><body>")
            .append("<div class='car-container'>");

        // Parcourir la liste des voitures et ajouter une carte HTML pour chacune
        for (cars car : cars) {
            if (!car.isRented()) {
                result.append("<div class='car'>")
                    .append("<div class='car-header'>Plaque : ").append(car.getPlateNumber()).append("</div>")
                    .append("<div class='car-details'>Marque : ").append(car.getBrand()).append("</div>")
                    .append("<div class='car-details'>Prix : <span class='price'>").append(car.getPrice()).append("€</span></div>")
                    .append("<div class='rental-status'>Location : ").append(car.isRented() ? "Oui" : "Non").append("</div>")
                    .append("</div>");
                }
        }

        // Fin du HTML
        result.append("</div></body></html>");

        return result.toString();
    }

    @PutMapping("/cars/{plateNumber}")
    public String rentCar(@PathVariable("plateNumber") String plateNumber) {
        System.out.println("Début du processus de location pour la voiture avec plaque : " + plateNumber);
        StringBuilder result = new StringBuilder();
    
        result.append("<html><head><style>...</style></head><body><div class='result-container'>");
    
        for (cars car : cars) {
            System.out.println("Voiture en cours de vérification : " + car.getPlateNumber());
            if (car.getPlateNumber().equals(plateNumber)) {
                System.out.println("Correspondance trouvée pour la plaque : " + plateNumber);
                if (!car.isRented()) {
                    car.setRented(true);
                    result.append("<div class='success'>La voiture avec la plaque ")
                          .append(plateNumber).append(" a été louée avec succès.</div>");
                    System.out.println("Voiture louée avec succès : " + plateNumber);
                } else {
                    result.append("<div class='error'>La voiture avec la plaque ")
                          .append(plateNumber).append(" est déjà louée.</div>");
                    System.out.println("Voiture déjà louée : " + plateNumber);
                }
                result.append("</div></body></html>");
                return result.toString();
            }
        }
    
        System.out.println("Aucune voiture trouvée avec la plaque : " + plateNumber);
        result.append("<div class='error'>Voiture avec la plaque ").append(plateNumber)
              .append(" non trouvée.</div></div></body></html>");
        return result.toString();
    }
    

// voiture nos louer 
@GetMapping("/cars/unrented")
public String listOfUnrentedCars() {
    StringBuilder result = new StringBuilder();
    result.append("<html><head><style>...</style></head><body><div class='car-container'>");

    for (cars car : cars) {
        if (!car.isRented()) {
            result.append("<div class='car'>")
                  .append("<div class='car-header'>Plaque : ").append(car.getPlateNumber()).append("</div>")
                  .append("<div class='car-details'>Marque : ").append(car.getBrand()).append("</div>")
                  .append("<div class='car-details'>Prix : <span class='price'>").append(car.getPrice()).append("€</span></div>")
                  .append("</div>");
        }
    }

    result.append("</div></body></html>");
    return result.toString();
}


}

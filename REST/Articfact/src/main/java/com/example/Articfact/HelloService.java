package com.example.Articfact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
            result.append("<div class='car'>")
                .append("<div class='car-header'>Plaque : ").append(car.getPlateNumber()).append("</div>")
                .append("<div class='car-details'>Marque : ").append(car.getBrand()).append("</div>")
                .append("<div class='car-details'>Prix : <span class='price'>").append(car.getPrice()).append("€</span></div>")
                .append("</div>");
        }

        // Fin du HTML
        result.append("</div></body></html>");

        return result.toString();
    }

    // Route pour louer une voiture
    /**@PutMapping("/cars/{plateNumber}/rent")
    public String rentCar(@PathVariable String plateNumber) {
        StringBuilder result = new StringBuilder();
    
        // Début du HTML avec CSS pour formater la réponse
        result.append("<html><head><style>")
              .append("body { font-family: Arial, sans-serif; background-color: #f4f4f9; }")
              .append(".result-container { width: 80%; margin: 20px auto; text-align: center; padding: 20px; background-color: #fff; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }")
              .append(".success { color: #4CAF50; font-size: 18px; font-weight: bold; }")
              .append(".error { color: #f44336; font-size: 18px; font-weight: bold; }")
              .append("</style></head><body>")
              .append("<div class='result-container'>");
    
        // Parcourir la liste des voitures pour trouver celle à louer
        for (cars car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                if (!car.isRented()) {
                    car.setRented(true); // Louer la voiture
                    result.append("<div class='success'>La voiture avec la plaque ")
                          .append(plateNumber).append(" a été louée avec succès.</div>");
                } else {
                    result.append("<div class='error'>La voiture avec la plaque ")
                          .append(plateNumber).append(" est déjà louée.</div>");
                }
                result.append("</div></body></html>");
                return result.toString();  // Retourner la réponse HTML
            }
        }
    
        // Si la voiture n'est pas trouvée
        result.append("<div class='error'>Voiture avec la plaque ").append(plateNumber)
              .append(" non trouvée.</div></div></body></html>");
        return result.toString();
    }
    
    @GetMapping("/cars/{plateNumber}/rent")
    public String rentCarViaGet(@PathVariable String plateNumber) {
        return rentCar(plateNumber);  // Appelle la méthode PUT pour réutiliser la logique
    }*/


}

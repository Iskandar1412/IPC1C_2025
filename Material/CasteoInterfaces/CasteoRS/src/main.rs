// cargo new <Nombre_Proyecto>
// cd <Nombre_Proyecto>
// cargo run 

use std::any::Any;

// Definicion similar al interface (Rust no cuenta con interfaces como tal)
trait Animal {
    fn sonido_animal(&self);
    fn as_any(&self) -> &dyn Any;
}


// Implementación de trait para los animales
struct Gato;
struct Perro;

impl Animal for Gato {
    fn sonido_animal(&self) {
        println!("Miau, soy un gato");
    }

    fn as_any(&self) -> &dyn Any {
        self
    }
}

impl Animal for Perro {
    fn sonido_animal(&self) {
        println!("Guauf, soy un perro");
    }

    fn as_any(&self) -> &dyn Any {
        self
    }
}

// ------------
fn main() {
    // upcasting: uso de trait object para almacenar objeto animal
    let animal1: Box<dyn Animal> = Box::new(Gato);
    let animal2: Box<dyn Animal> = Box::new(Perro);

    animal1.sonido_animal();
    animal2.sonido_animal();
    
    // downcasting explícito: convertir el trait object al animal
    if let Some(gatito1) = animal1.as_any().downcast_ref::<Gato>() {
        gatito1.sonido_animal();
    } else if let Some(perrito1) = animal2.as_any().downcast_ref::<Perro>() {
        perrito1.sonido_animal();
    } else {
        println!("Error en conversión");
    }
    
    // vector
    let animales: Vec<Box<dyn Animal>> = vec![animal1, animal2];
    
    for animal in animales {
        if let Some(gato) = animal.as_any().downcast_ref::<Gato>() {
            gato.sonido_animal();
        } else if let Some(perro) = animal.as_any().downcast_ref::<Perro>() {
            perro.sonido_animal();
        } else {
            println!("Error en conversión");
        }
    }
}
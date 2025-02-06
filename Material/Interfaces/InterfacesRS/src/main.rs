// Agregar dependencia rand = "<version>" en Cargo.toml
use rand::Rng;
use std::fmt;

// Definición trait
trait Guerrero {
    fn atacar(&self);
    fn defender(&self);
    fn habilidad_especial(&self);
}

// Kratos
struct Kratos;
impl Guerrero for Kratos {
    fn atacar(&self) {
        println!("Kratos ataca con las Espadas del Caos!");
    }

    fn defender(&self) {
        println!("Kratos bloquea con el Escudo Guardián!");
    }

    fn habilidad_especial(&self) {
        println!("Kratos usa la Ira Espartana!");
    }
}

// Atreus
struct Atreus;
impl Guerrero for Atreus {
    fn atacar(&self) {
        println!("Atreus dispara una flecha mágica!");
    }

    fn defender(&self) {
        println!("Atreus esquiva ágilmente!");
    }

    fn habilidad_especial(&self) {
        println!("Atreus invoca a los lobos espirituales!");
    }
}

// Thor
struct Thor;
impl Guerrero for Thor {
    fn atacar(&self) {
        println!("Thor lanza Mjölnir con furia!");
    }

    fn defender(&self) {
        println!("Thor se protege con su enorme resistencia divina!");
    }

    fn habilidad_especial(&self) {
        println!("Thor desata una tormenta de rayos!");
    }
}

struct Batalla<'a> {
    guerrero1: &'a dyn Guerrero,
    guerrero2: &'a dyn Guerrero,
}

impl<'a> Batalla<'a> {
    fn new(g1: &'a dyn Guerrero, g2: &'a dyn Guerrero) -> Self {
        Batalla {
            guerrero1: g1,
            guerrero2: g2,
        }
    }

    fn iniciar_combate(&self) {
        println!("\n¡COMIENZA LA BATALLA!");
        let mut rng = rand::thread_rng();

        for i in 0..3 {
            println!("\n--> RONDA {}", i + 1);
            if rng.gen::<bool>() {
                self.guerrero1.atacar();
                self.guerrero2.defender();
            } else {
                self.guerrero2.atacar();
                self.guerrero1.defender();
            }

            if rng.gen::<bool>() {
                self.guerrero1.habilidad_especial();
            } else {
                self.guerrero2.habilidad_especial();
            }
        }
        println!("\n¡LA BATALLA HA TERMINADO!");
    }
}

fn main() {
    // Instancias
    let kratos = Kratos;
    let thor = Thor;
    let atreus = Atreus;

    // Kratos vs Thor
    let batalla1 = Batalla::new(&kratos, &thor);
    batalla1.iniciar_combate();

    println!("\n==============================");

    // Atreus vs Thor
    let batalla2 = Batalla::new(&atreus, &thor);
    batalla2.iniciar_combate();
}
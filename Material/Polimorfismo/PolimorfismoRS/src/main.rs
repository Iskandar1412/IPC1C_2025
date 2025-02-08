// Trait Saiyajin (interfaz)
trait Saiyajin {
    fn atacar(&self);
    fn transformarse(&mut self);
    fn ataque_especial(&self);
    fn get_nombre(&self) -> &str;
    fn get_nivel_poder(&self) -> i32;
}

// Estructura base
struct BaseSaiyajin {
    nombre: String,
    nivel_poder: i32,
}

impl BaseSaiyajin {
    fn new(nombre: &str, nivel_poder: i32) -> Self {
        BaseSaiyajin {
            nombre: nombre.to_string(),
            nivel_poder,
        }
    }
}

impl Saiyajin for BaseSaiyajin {
    fn atacar(&self) {
        println!("{} golpea con sus puños", self.nombre);
    }

    fn transformarse(&mut self) {
        panic!("El método transformarse debe ser implementado por las subclases");
    }

    fn ataque_especial(&self) {
        println!("{} lanza una habilidad especial", self.nombre);
    }

    fn get_nombre(&self) -> &str {
        &self.nombre
    }

    fn get_nivel_poder(&self) -> i32 {
        self.nivel_poder
    }
}

// Goku
struct Goku {
    base: BaseSaiyajin,
}

impl Goku {
    fn new() -> Self {
        Goku {
            base: BaseSaiyajin::new("Goku", 9000),
        }
    }
}

impl Saiyajin for Goku {
    fn atacar(&self) {
        self.base.atacar();
    }

    fn transformarse(&mut self) {
        println!("{} se transforma en Super Saiyajin Fase 3!", self.base.nombre);
        self.base.nivel_poder *= 50;
    }

    fn ataque_especial(&self) {
        println!("{} lanza un Kamehameha!", self.base.nombre);
    }

    fn get_nombre(&self) -> &str {
        self.base.get_nombre()
    }

    fn get_nivel_poder(&self) -> i32 {
        self.base.get_nivel_poder()
    }
}

// Vegeta
struct Vegeta {
    base: BaseSaiyajin,
}

impl Vegeta {
    fn new() -> Self {
        Vegeta {
            base: BaseSaiyajin::new("Vegeta", 8500),
        }
    }
}

impl Saiyajin for Vegeta {
    fn atacar(&self) {
        self.base.atacar();
    }

    fn transformarse(&mut self) {
        println!("{} se transforma en Super Saiyajin Fase 2!", self.base.nombre);
        self.base.nivel_poder *= 45;
    }

    fn ataque_especial(&self) {
        println!("{} lanza un ataque de Brillo Final!", self.base.nombre);
    }

    fn get_nombre(&self) -> &str {
        self.base.get_nombre()
    }

    fn get_nivel_poder(&self) -> i32 {
        self.base.get_nivel_poder()
    }
}

// Broly
struct Broly {
    base: BaseSaiyajin,
}

impl Broly {
    fn new() -> Self {
        Broly {
            base: BaseSaiyajin::new("Broly", 12000),
        }
    }
}

impl Saiyajin for Broly {
    fn atacar(&self) {
        self.base.atacar();
    }

    fn transformarse(&mut self) {
        println!("{} se transforma en Super Saiyajin Legendario!", self.base.nombre);
        self.base.nivel_poder *= 70;
    }

    fn ataque_especial(&self) {
        println!("{} lanza una Erupción Omega!", self.base.nombre);
    }

    fn get_nombre(&self) -> &str {
        self.base.get_nombre()
    }

    fn get_nivel_poder(&self) -> i32 {
        self.base.get_nivel_poder()
    }
}

fn main() {
    // Creación de instancias
    let mut goku = Goku::new();
    let mut vegeta = Vegeta::new();
    let mut broly = Broly::new();

    // Arreglo (polimorfismo)
    let mut guerreros: Vec<&mut dyn Saiyajin> = vec![&mut goku, &mut vegeta, &mut broly];

    println!("¡Comienza la batalla!\n");

    for guerrero in &mut guerreros {
        println!("{} entra en combate!", guerrero.get_nombre());
        guerrero.atacar();
        guerrero.transformarse();
        guerrero.ataque_especial();
        println!(
            "Nivel de poder actual de <<{}>>: {}\n",
            guerrero.get_nombre(),
            guerrero.get_nivel_poder()
        );
    }

    println!("¡Fin del combate!");
}
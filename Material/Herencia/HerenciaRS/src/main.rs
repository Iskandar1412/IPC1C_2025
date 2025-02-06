// Clase padre
struct Pokemon {
    nombre: String,
}

impl Pokemon {
    // Constructor
    fn new(nombre: &str) -> Self {
        Pokemon {
            nombre:nombre.to_string(),
        }
    }

    // Método para heredar
    fn comer(&self) {
        println!("{} esta comiendo detenidamete", self.nombre);
    }
}

// Clases hijas (derivadas)
struct TipoRoca {
    pokemon: Pokemon, // composición (simula la herencia)
    raza: String,
}

struct TipoPsiquico {
    pokemon: Pokemon,
    raza: String,
}

impl TipoRoca {
    // Constructor
    fn new(nombre: &str, raza: &str) -> Self {
        TipoRoca {
            pokemon: Pokemon::new(nombre),
            raza: raza.to_string(),
        }
    }

    // Método exclusivo
    fn ataque_fuerte(&self) {
        println!("{} uso golpe roca", self.pokemon.nombre);
    }

    // Sobreescritura método (simulada)
    fn comer(&self) {
        println!("{} (un {}) está comiendo tranquilamente", self.pokemon.nombre, self.raza);
    }
}

impl TipoPsiquico {
    fn new(nombre: &str, raza: &str) -> Self {
        TipoPsiquico {
            pokemon: Pokemon::new(nombre),
            raza: raza.to_string(),
        }
    }

    fn especial(&self) {
        println!("{} uso meteoro psiquico", self.pokemon.nombre);
    }

    fn comer(&self) {
        println!("{} (un {}) está observando sin mas su comida", self.pokemon.nombre, self.raza);
    }
}

fn main() {
    // Crear instancia pokemon
    let pokemon = Pokemon::new("Doge");
    pokemon.comer();

    // Instancias pokemones
    let onyx = TipoRoca::new("Onyx", "¿Pokemon?");
    let deoxys = TipoPsiquico::new("Deoxys", "¿Pokemon?");

    // llamada de métodos
    onyx.comer();
    onyx.ataque_fuerte();

    deoxys.comer();
    deoxys.especial();
}
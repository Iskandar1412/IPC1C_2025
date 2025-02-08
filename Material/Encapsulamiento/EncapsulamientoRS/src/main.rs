// Declaración estructura persona
pub struct Persona {
    nombre: String,
    edad: u32,
}

impl Persona {
    // Constructor persona
    pub fn new(nombre: &str, edad: u32) -> Result<Self, String> {
        if edad == 0 {
            Err("La edad no puede ser menor o igual a 0".to_string())
        } else {
            Ok(Persona {
                nombre: nombre.to_string(),
                edad,
            })
        }
    }

    // métodos
    pub fn get_nombre(&self) -> &str {
        &self.nombre
    }

    pub fn get_edad(&self) -> u32 {
        self.edad
    }

    pub fn set_nombre(&mut self, nombre: &str) {
        self.nombre = nombre.to_string();
    }

    pub fn set_edad(&mut self, edad: u32) -> Result<(), String> {
        if edad > 0 {
            self.edad = edad;
            Ok(())
        } else {
            Err("La edad no puede ser menor o igual a 0".to_string())
        }
    }

    pub fn info_persona(&self) {
        println!("------------------------------------");
        println!("Persona");
        println!("Nombre: {}, Edad: {}", self.nombre, self.edad);
        println!("------------------------------------");
    }
}

fn main() {
    // Creación instancia persona
    let mut persona = match Persona::new("Mario", 22) {
        Ok(temp) => temp,
        Err(err) => {
            println!("{}", err);
            return;
        } 
    };

    persona.info_persona();

    // Modificar datos
    if let Err(er) = persona.set_edad(25) {
        println!("{}", er);
    }
    persona.set_nombre("Carlos");
    persona.info_persona();

    // Edad no valida
    if let Err(er) = persona.set_edad(0) {
        println!("{}", er);
    }
    persona.info_persona();
}
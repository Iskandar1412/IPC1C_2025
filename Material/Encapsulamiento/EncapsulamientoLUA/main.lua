-- Definimos clase Persona
Persona = {}
Persona.__index = Persona

-- Constructor de persona
function Persona:new(nombre, edad)
    local persona = setmetatable({}, self) -- nueva instancia
    persona.nombre = nombre
    persona:setEdad(edad)
    return persona
end

-- Métodos de persona
-- Gets
function Persona:getNombre()
    return self.nombre
end

function Persona:getEdad()
    return self.edad
end

-- Sets
function Persona:setNombre(nombre)
    self.nombre = nombre
end

function Persona:setEdad(edad)
    if edad > 0 then
        self.edad = edad
    else
        print("La edad no puede ser igual o menor a 0")
    end
end

-- Impresión
function Persona:infoPersona()
    print("------------------------------------")
    print("Persona")
    print(string.format("Nombre: %s, Edad: %d", self.nombre, self.edad))
    print("------------------------------------")
end

-- --------------
function main()
    -- Crear instancia de persona
    local persona = Persona:new("Mario", 22)
    persona:infoPersona()

    -- Modificar persona
    persona:setEdad(25)
    persona:setNombre("Carlos")
    persona:infoPersona()

    -- cambiar a edad no valida
    persona:setEdad(-5)
    persona:infoPersona()
end

main()
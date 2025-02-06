-- Superclase (la simulamos con una tabla)
Saiyajin = {}
Saiyajin.__index = Saiyajin

function Saiyajin:new(nombre, nivelPoder)
    local saiyajin = setmetatable({}, self)
    saiyajin.nombre = nombre
    saiyajin.nivelPoder = nivelPoder
    return saiyajin
end

function Saiyajin:atacar()
    print(self.nombre .. " golpea con sus puños")
end

function Saiyajin:transformarse()
    error("El método transformarse debe ser implementado por las subclases")
end

function Saiyajin:ataqueEspecial()
    print(self.nombre .. " lanza una habilidad especial")
end

-- Goku
Goku = {}
Goku.__index = Goku
setmetatable(Goku, Saiyajin) -- Herencia simulada

function Goku:new()
    local goku = Saiyajin:new("Goku", 9000)
    setmetatable(goku, self)
    return goku
end

function Goku:transformarse()
    print(self.nombre .. " se transforma en Super Saiyajin Fase 3!")
    self.nivelPoder = self.nivelPoder * 50
end

function Goku:ataqueEspecial()
    print(self.nombre .. " lanza un Kamehameha!")
end

-- Vegeta
Vegeta = {}
Vegeta.__index = Vegeta
setmetatable(Vegeta, Saiyajin) -- Herencia simulada

function Vegeta:new()
    local vegeta = Saiyajin:new("Vegeta", 8500)
    setmetatable(vegeta, self)
    return vegeta
end

function Vegeta:transformarse()
    print(self.nombre .. " se transforma en Super Saiyajin Fase 2!")
    self.nivelPoder = self.nivelPoder * 45
end

function Vegeta:ataqueEspecial()
    print(self.nombre .. " lanza un ataque de Brillo Final!")
end

-- Broly
Broly = {}
Broly.__index = Broly
setmetatable(Broly, Saiyajin) -- Herencia simulada

function Broly:new()
    local broly = Saiyajin:new("Broly", 12000)
    setmetatable(broly, self)
    return broly
end

function Broly:transformarse()
    print(self.nombre .. " se transforma en Super Saiyajin Legendario!")
    self.nivelPoder = self.nivelPoder * 70
end

function Broly:ataqueEspecial()
    print(self.nombre .. " lanza una Erupción Omega!")
end


function main()
    -- Creación de instancias
    local goku = Goku:new()
    local vegeta = Vegeta:new()
    local broly = Broly:new()

    -- Arreglo (polimorfismo simulado)
    local guerreros = {goku, vegeta, broly}

    print("¡Comienza la batalla!\n")

    for _, guerrero in ipairs(guerreros) do
        print(guerrero.nombre .. " entra en combate!")
        guerrero:atacar()
        guerrero:transformarse()
        guerrero:ataqueEspecial()
        print("Nivel de poder actual de <<" .. guerrero.nombre .. ">>: " .. guerrero.nivelPoder .. "\n")
    end

    print("¡Fin del combate!")
end

main()
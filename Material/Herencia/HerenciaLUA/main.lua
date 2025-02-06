-- Clase padre
Pokemon = {}
Pokemon.__index = Pokemon

function Pokemon:new(nombre)
    local pokemon = setmetatable({}, self)
    pokemon.nombre = nombre
    return pokemon
end

function Pokemon:comer()
    print(self.nombre .. " está comiendo atentamente")
end

-- Clases derivadas (hijas)
TipoTierra = {}
TipoTierra.__index = TipoTierra
setmetatable(TipoTierra, Pokemon) -- herencia (simulada)

TipoVolador = {}
TipoVolador.__index = TipoVolador
setmetatable(TipoVolador, Pokemon)

function TipoTierra:new(nombre, raza)
    local pokemon = Pokemon:new(nombre)
    setmetatable(pokemon, self)
    self.__index = self
    pokemon.raza = raza
    return pokemon
end

function TipoVolador:new(nombre, raza)
    local pokemon = Pokemon:new(nombre)
    setmetatable(pokemon, self)
    self.__index = self
    pokemon.raza = raza
    return pokemon
end

-- Métodos únicos
function TipoTierra:ataque()
    print(self.nombre .. " usa placaje")
end

function TipoVolador:habilidad()
    print(self.nombre .. " va a usar viento cortante")
end

-- Sobreescritura
function TipoTierra:comer()
    print(self.nombre .. " (un " .. self.raza .. ") esta comiendo mientras observa")
end

function TipoVolador:comer()
    print(self.nombre .. " (un " .. self.raza .. ") esta observando su plato")
end

function main()
    -- Creación instancia pokemon
    local pokemon = Pokemon:new("Mew")
    pokemon:comer()

    -- Creación instancias pokemones
    local solrock = TipoTierra:new("Solrock", "¿Pokemon?")
    local dragonite = TipoVolador:new("Dragonite", "¿Pokemon?")

    -- Llamada a métodos
    solrock:comer()
    solrock:ataque()

    dragonite:comer()
    dragonite:habilidad()
end

main()
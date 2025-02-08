-- lua <archivo>.lua

-- Definición clase Animal
Animal = {}
Animal.__index = Animal

function Animal:new()
    local animal = {}
    setmetatable(animal, self)
    return animal
end

function Animal:sonidoAnimal()
    error('Metodo del sonidoAnimal')
end

-- Clases animales hijas (heredan de Animal)
Gato = {}
Gato.__index = Gato
setmetatable(Gato, Animal)

Perro = {}
Perro.__index = Perro
setmetatable(Perro, Animal)

function Gato:new()
    local gato = Animal:new() -- crear instancia animal
    setmetatable(gato, self) -- configuración metatabla de instancia como gato
    return gato
end

function Gato:sonidoAnimal()
    print("Miau, soy un gato")
end

function Perro:new()
    local perro = Animal:new()
    setmetatable(perro, self)
    return perro
end

function Perro:sonidoAnimal()
    print("Guauf, soy un perro")
end

function main()
    -- instancias animales
    local gato = Gato:new()
    local perro = Perro:new()

    gato:sonidoAnimal()
    perro:sonidoAnimal()

    -- tabla de animales
    local animales = {gato, perro}

    for _, animal in ipairs(animales) do
        animal:sonidoAnimal()
    end
end

main()
-- Interfaz Guerrero (simulada con una tabla)
Guerrero = {}

-- Kratos
Kratos = {}
Kratos.__index = Kratos

function Kratos:new()
    local kratos = setmetatable({}, self)
    kratos.nombre = "Kratos"
    return kratos
end

function Kratos:atacar()
    print(self.nombre .. " ataca con las Espadas del Caos!")
end

function Kratos:defender()
    print(self.nombre .. " bloquea con el Escudo Guardián!")
end

function Kratos:habilidadEspecial()
    print(self.nombre .. " usa la Ira Espartana!")
end

-- Atreus
Atreus = {}
Atreus.__index = Atreus

function Atreus:new()
    local atreus = setmetatable({}, self)
    atreus.nombre = "Atreus"
    return atreus
end

function Atreus:atacar()
    print(self.nombre .. " dispara una flecha mágica!")
end

function Atreus:defender()
    print(self.nombre .. " esquiva ágilmente!")
end

function Atreus:habilidadEspecial()
    print(self.nombre .. " invoca a los lobos espirituales!")
end

-- Thor
Thor = {}
Thor.__index = Thor

function Thor:new()
    local thor = setmetatable({}, self)
    thor.nombre = "Thor"
    return thor
end

function Thor:atacar()
    print(self.nombre .. " lanza Mjölnir con furia!")
end

function Thor:defender()
    print(self.nombre .. " se protege con su enorme resistencia divina!")
end

function Thor:habilidadEspecial()
    print(self.nombre .. " desata una tormenta de rayos!")
end

-- Batalla
Batalla = {}
Batalla.__index = Batalla

function Batalla:new(guerrero1, guerrero2)
    local batalla = setmetatable({}, self)
    batalla.guerrero1 = guerrero1
    batalla.guerrero2 = guerrero2
    return batalla
end

function Batalla:iniciarCombate()
    print("\n¡COMIENZA LA BATALLA!")
    math.randomseed(os.time())

    for i = 1, 3 do
        print("\n--> RONDA " .. i)

        if math.random(0, 1) == 0 then
            self.guerrero1:atacar()
            self.guerrero2:defender()
        else
            self.guerrero2:atacar()
            self.guerrero1:defender()
        end

        if math.random(0, 1) == 0 then
            self.guerrero1:habilidadEspecial()
        else
            self.guerrero2:habilidadEspecial()
        end
    end

    print("\n¡LA BATALLA HA TERMINADO!")
end

function main()
    -- Instancias guerreros
    local kratos = Kratos:new()
    local thor = Thor:new()
    local atreus = Atreus:new()

    -- Kratos vs Thor
    local batalla1 = Batalla:new(kratos, thor)
    batalla1:iniciarCombate()

    print("\n==============================")

    -- Atreus vs Thor
    local batalla2 = Batalla:new(atreus, thor)
    batalla2:iniciarCombate()
end

main()
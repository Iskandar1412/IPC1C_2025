-- Función de impresión
local function imprimirArreglo(texto, array)
    io.write(texto .. ": {")
    for i, v in ipairs(array) do 
        io.write(v)
        if i < #array then io.write(", ") end
    end
    io.write("}\n")
end

-- Bubble Sort
local function Bubble(array)
    print("Bubble Sort (Started)...")
    for i = 1, #array - 1 do
        for j = 1, #array - i do
            if array[j] > array[j + 1] then
                array[j], array[j + 1] = array[j + 1], array[j]
                imprimirArreglo("Array (Bubble)", array)
            end
            coroutine.yield() -- Simular concurrencia
        end
    end
    print("Bubble Sort (Ended): " .. table.concat(array, ", "))
end

-- Selection Sort
local function Selection(array)
    print("Selection Sort (Started)...")
    for i = 1, #array - 1 do
        local minIndex = i
        for j = i + 1, #array do
            if array[j] < array[minIndex] then
                minIndex = j
            end
        end
        if minIndex ~= i then
            array[i], array[minIndex] = array[minIndex], array[i]
            imprimirArreglo("Array (Selection)", array)
        end
        coroutine.yield() -- Simular concurrencia
    end
    print("Selection Sort (Ended): " .. table.concat(array, ", "))
end

function main() 
    local array1 = {900, 150, 21, 0, 154, 26, 51, 22, 1, 33, 3}
    local array2 = {900, 150, 21, 0, 154, 26, 51, 22, 1, 33, 3}

    -- Creación coroutines
    local bubble = coroutine.create(function() Bubble(array1) end)
    local selection = coroutine.create(function() Selection(array2) end)

    -- Ejecución coroutines de forma alterna
    while coroutine.status(bubble) ~= "dead" or coroutine.status(selection) ~= "dead" do
        if coroutine.status(bubble) ~= "dead" then coroutine.resume(bubble) end
        if coroutine.status(selection) ~= "dead" then coroutine.resume(selection) end
    end

    print("Programa Finalizado")
end

main()
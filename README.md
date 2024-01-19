# SensorsProject
REST API service that accepts data from "sensor"

# Проект "Симуляция".

___
# 😼 🌳 🐭 🌽 

## Задача
___

Пошаговая симуляция 2D мира, населённого травоядными и хищниками. Кроме существ, мир содержит ресурсы (траву), 
которыми питаются травоядные и статичные объекты, с которыми нельзя взаимодействовать - они просто занимают место.

2D мир представляет из себя матрицу NxM, каждое существо или объект занимают клетку целиком, нахождение в клетке нескольких объектов/существ - недопустимо.



## Механика мира:
___

* У животных есть запас здоровья и насыщение;
* Если насыщение упало до 0, животное начинает терять здоровье;
* У кошек есть сила урона;
* Мыши ищут зерно. Находясь в соседней клетке - съедают, повышая насыщение и здоровье;
* Кошки ищут мышей. Находясь в соседней клетке - атакуют. Если мышь съедена, повышается насыщение и здоровье.
* У зверей есть скорость (сколько клеток они могут пройти за 1 итерацию), у кошек она вдвое больше чем у мышей;
* В мире реализован механизм восполнения животных и еды.





 
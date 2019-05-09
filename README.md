# Bet-Service-Group-LTD-TEST-Task
Репозиторій для виконання тестового завдання для компанії Bet Service Group LTD

Детали задания:
Создать страницу статистики поста используя макет во вложении и API методы.

Информацию о посте можно получить методом:
https://api.inrating.top/v1/users/posts/get
параметр: slug поста 
( есть в URL поста, например https://inrating.top/p/suCP11LONie4)

Токен передавать в заголовках при запросах к методам API
Authorization='Bearer токен'

Детали задания:

Получить всех людей, которые лайкнули пост
https://api.inrating.top/v1/users/posts/likers/all
параметр: id поста 

Получить всех людей, которые зарепостили пост
https://api.inrating.top/v1/users/posts/reposters/all
параметр: id поста 

Получить всех людей, которые комментировали пост
https://api.inrating.top/v1/users/posts/commentators/all
параметр: id поста 

Получить всех людей, которые были отмеченные на посте
https://api.inrating.top/v1/users/posts/mentions/all
параметр: id поста

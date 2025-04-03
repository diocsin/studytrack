🧑‍💻 Инструкция для студентов: как работать с Git и ветками
Добро пожаловать в командную разработку проекта StudyTrack!
Мы используем GitHub, ветки, и pull request'ы, как в настоящих IT-командах.

✅ Общий процесс
Клонируй репозиторий

Создай свою ветку

Пиши код

МЕРЖИ main В СВОЮ ВЕТКУ

Реши конфликты, если они есть

Пуш

Создай Pull Request

🔁 Полная инструкция
1. Клонируй репозиторий
bash
Copy
git clone https://github.com/ИМЯ-ПРОЕКТА/studytrack.git
cd studytrack
2. Создай свою ветку
bash
Copy
git checkout -b participant-1
Примеры имён веток:

participant-2

task-statistics

fix-course-enroll

3. Пиши код
Работай только в своих классах.
Коммить:

bash
Copy
git add .
git commit -m "Реализовал методы assignGrade и calculateAverageGrade"
4. ОБЯЗАТЕЛЬНО перед пушем: подтяни изменения из main
bash
Copy
git checkout main
git pull origin main         # получи последние изменения
git checkout participant-1   # вернись в свою ветку
git merge main               # слей main в свою ветку
Если будут конфликты — реши их и сделай:

bash
Copy
git add .
git commit -m "Merge main into participant-1"
5. Пуш своей ветки
bash
Copy
git push origin participant-1
6. Создай Pull Request
Перейди на GitHub

Нажми Compare & pull request

Опиши, что сделано

Нажми Create pull request

🔒 Правила
❌ Прямой пуш в main запрещён

✅ Только через pull request

✅ Перед пушем всегда мержим main!

🛠 Полезные команды
Операция	Команда
Статус	git status
Создать ветку	git checkout -b my-feature
Получить последние изменения	git pull origin main
Слить main в свою ветку	git merge main
Пуш	git push origin my-feature
📌 Если что-то не понятно — спрашивай! Мы одна команда 💪

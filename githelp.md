# 🧑‍💻 Инструкция для студентов: как работать с Git и ветками

Добро пожаловать в командную разработку проекта **StudyTrack**!  
Мы используем GitHub, ветки и pull request'ы, как в настоящих IT-командах.

---

## ✅ Общий процесс

1. Клонируй репозиторий  
2. Создай свою ветку  
3. Пиши код  
4. МЕРЖИ `master` в СВОЮ ветку  
5. Реши конфликты, если они есть  
6. Пуш  
7. Создай Pull Request  

---

## 🔁 Полная инструкция

### 1. Клонируй репозиторий

```bash
git clone https://github.com/ИМЯ-ПРОЕКТА/studytrack.git
cd studytrack
```

---

### 2. Создай свою ветку

```bash
git checkout -b participant-1
```

Примеры имён веток:

- `participant-2`
- `task-statistics`
- `fix-course-enroll`

---

### 3. Пиши код

Работай **только в своих классах**.  
Коммить изменения:

```bash
git add .
git commit -m "Реализовал методы assignGrade и calculateAverageGrade"
```

---

### 4. ОБЯЗАТЕЛЬНО перед пушем: подтяни `master`

```bash
git checkout master
git pull origin master         # получи последние изменения
git checkout participant-1   # вернись в свою ветку
git merge master               # слей master в свою ветку
```

Если будут конфликты — реши их, потом:

```bash
git add .
git commit -m "Merge master into participant-1"
```

---

### 5. Пуш своей ветки

```bash
git push origin participant-1
```

---

### 6. Создай Pull Request

1. Перейди в репозиторий на GitHub  
2. Нажми **Compare & pull request**  
3. Опиши, что сделано  
4. Нажми **Create pull request**

---

## 🔒 Правила

- ❌ Прямой пуш в `master` запрещён
- ✅ Только через pull request
- ✅ Перед пушем **всегда мержим `master`**

---

## 🛠 Полезные команды

| Операция                    | Команда                          |
|----------------------------|----------------------------------|
| Статус                     | `git status`                     |
| Создать ветку              | `git checkout -b my-feature`     |
| Получить изменения из master | `git pull origin master`           |
| Слить master в свою ветку    | `git merge master`                 |
| Пуш                        | `git push origin my-feature`     |

---

📌 Если что-то не понятно — спрашивай! Мы одна команда 💪

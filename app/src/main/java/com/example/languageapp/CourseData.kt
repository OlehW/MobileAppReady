package com.example.languageapp

data class Course(
    val id: Int,
    val title: String,
    val level: String,
    val lessons: List<Lesson>,
    val imageResId: Int
)

data class Lesson(
    val id: Int,
    val title: String,
    val topic: String,
    val stages: List<LessonStage>
)

sealed class LessonStage {
    data class Content(val text: String) : LessonStage()
    data class Quiz(val question: String, val options: List<String>, val correctAnswerIndex: Int) : LessonStage()
    data class MultipleQuiz(val quizzes: List<QuizBlock>) : LessonStage()
}

data class QuizBlock(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

object CourseData {
    val courses = listOf(
        Course(
            id = 1,
            title = "Граматика",
            level = "Англійська рівень А1",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Англійська абетка та вимова",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Англійський алфавіт</b> складається з 26 літер:<br><br>"
                                    + "<b>Голосні:</b> A, E, I, O, U<br>"
                                    + "<b>Приголосні:</b> B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z.<br><br>"
                                    + "<b>Цікаві факти:</b><br>"
                                    + "- Літера 'E' є найпоширенішою в англійській мові.<br>"
                                    + "- Літера 'Q' майже завжди використовується разом із 'U', наприклад, у слові <b>queen</b>.<br>"
                        ),
                        LessonStage.Quiz(
                            question = "Скільки літер у англійському алфавіті?",
                            options = listOf("24", "25", "26", "27"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Вимова голосних літер</b>:<br><br>"
                                    + "Голосні літери можуть мати різну вимову залежно від положення у слові:<br>"
                                    + "- Літера 'A' вимовляється як [eɪ] у слові <b>cake</b>, але як [æ] у слові <b>cat</b>.<br>"
                                    + "- Літера 'I' вимовляється як [aɪ] у слові <b>time</b>, але як [ɪ] у слові <b>bit</b>.<br>"
                        ),
                        LessonStage.Quiz(
                            question = "Як вимовляється літера 'A' у слові 'cake'?",
                            options = listOf("[a]", "[eɪ]", "[æ]", "[oʊ]"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Вимова приголосних літер</b>:<br><br>"
                                    + "Деякі приголосні літери мають декілька варіантів вимови:<br>"
                                    + "- Літера 'C' вимовляється як [s] у слові <b>city</b>, але як [k] у слові <b>cat</b>.<br>"
                                    + "- Літера 'G' вимовляється як [dʒ] у слові <b>giant</b>, але як [g] у слові <b>go</b>.<br>"
                        ),
                        LessonStage.Quiz(
                            question = "Як вимовляється літера 'G' у слові 'giant'?",
                            options = listOf("[g]", "[dʒ]", "[h]", "[ɡʊ]"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Наголос у словах</b>:<br><br>"
                                    + "Наголос у словах змінює вимову та значення слів:<br>"
                                    + "- У слові 'record' [ˈrek.ɔːrd] (іменник) наголос падає на перший склад.<br>"
                                    + "- У слові 'record' [rɪˈkɔːrd] (дієслово) наголос падає на другий склад.<br>"
                        ),
                        LessonStage.Quiz(
                            question = "На який склад падає наголос у слові 'record' (іменник)?",
                            options = listOf("Перший", "Другий", "Третій", "Жоден"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Особові займенники",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Особові займенники</b> використовуються для позначення осіб або предметів.<br>\n" +
                                    "В англійській мові є 7 особових займенників:<br>\n" +
                                    "- I – я<br>\n" +
                                    "- You – ти, ви<br>\n" +
                                    "- He – він<br>\n" +
                                    "- She – вона<br>\n" +
                                    "- It – воно (про предмети та тварин)<br>\n" +
                                    "- We – ми<br>\n" +
                                    "- They – вони<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який особовий займенник використовується для третьої особи чоловічого роду?",
                            options = listOf("She", "He", "They", "It"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Приклади використання:</b><br>\n" +
                                    "- I am a student. (Я – студент.)<br>\n" +
                                    "- She is my sister. (Вона – моя сестра.)<br>\n" +
                                    "- They are friends. (Вони – друзі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який займенник використовується для неживих предметів?",
                            options = listOf("We", "It", "He", "You"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Займенник 'You' може означати як одну людину, так і групу людей.</b><br>\n" +
                                    "- You are my friend. (Ти – мій друг.)<br>\n" +
                                    "- You are my students. (Ви – мої студенти.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який займенник використовується для звернення до групи людей?",
                            options = listOf("I", "We", "You", "They"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Артиклі (a, an, the)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Артиклі</b> – це службові слова, які вказують на визначеність або невизначеність іменника.<br>\n" +
                                    "В англійській мові є три види артиклів: <b>a</b>, <b>an</b>, <b>the</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Неозначені артиклі a / an</b><br>\n" +
                                    "- Використовуються з одниною злічуваних іменників.<br>\n" +
                                    "- 'A' ставиться перед словами, що починаються з приголосного звуку (a cat, a dog).<br>\n" +
                                    "- 'An' ставиться перед словами, що починаються з голосного звуку (an apple, an hour).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який артикль слід використати у фразі: '... apple'?",
                            options = listOf("A", "An", "The", "Не потрібно"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Означений артикль the</b><br>\n" +
                                    "- Використовується, коли мовець і слухач знають, про що йдеться (The sun is bright today).<br>\n" +
                                    "- Використовується перед унікальними об'єктами (The Moon, The Eiffel Tower).<br>\n" +
                                    "- Використовується перед іменниками, що вже згадувалися (I saw a dog. The dog was barking).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який артикль використовується перед унікальними об'єктами, як-от 'Eiffel Tower'?",
                            options = listOf("A", "An", "The", "Не потрібно"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Випадки, коли артикль не використовується:</b><br>\n" +
                                    "- Перед незлічуваними іменниками у загальному значенні (Water is important).<br>\n" +
                                    "- Перед іменами власними (John, London, Mount Everest).<br>\n" +
                                    "- Перед назвами днів тижня та місяців (Monday, July).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому реченні артикль не потрібен?",
                            options = listOf("I love a music", "She is the doctor", "Water is important", "We saw an elephant"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Основний порядок слів у реченні",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Основний порядок слів у англійському реченні</b><br>\n" +
                                    "В англійській мові речення мають фіксований порядок слів:<br>\n" +
                                    "<b>Підмет (хто?) + Присудок (що робить?) + Додаток (кого? що?)</b><br>\n" +
                                    "<br>\n" +
                                    "Наприклад:<br>\n" +
                                    "- <b>I</b> (підмет) <b>read</b> (присудок) <b>a book</b> (додаток).<br>\n" +
                                    "- <b>She</b> (підмет) <b>likes</b> (присудок) <b>coffee</b> (додаток).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який правильний порядок слів у реченні?",
                            options = listOf("Присудок + Підмет + Додаток", "Підмет + Додаток + Присудок", "Підмет + Присудок + Додаток", "Додаток + Підмет + Присудок"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення</b><br>\n" +
                                    "В англійській мові питання будуються за схемою:<br>\n" +
                                    "<b>Допоміжне дієслово + Підмет + Присудок + Додаток?</b><br>\n" +
                                    "<br>\n" +
                                    "Наприклад:<br>\n" +
                                    "- <b>Do</b> you like coffee?<br>\n" +
                                    "- <b>Does</b> she play tennis?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити питальне речення?",
                            options = listOf("Підмет + Присудок + Додаток?", "Допоміжне дієслово + Підмет + Присудок + Додаток?", "Присудок + Підмет + Додаток?", "Додаток + Присудок + Підмет?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечні речення</b><br>\n" +
                                    "Для утворення заперечення використовується 'not' після допоміжного дієслова:<br>\n" +
                                    "<b>Підмет + Допоміжне дієслово + not + Присудок + Додаток</b><br>\n" +
                                    "<br>\n" +
                                    "Наприклад:<br>\n" +
                                    "- I <b>do not</b> like tea.<br>\n" +
                                    "- She <b>does not</b> play football.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється заперечне речення?",
                            options = listOf("Підмет + Присудок + Додаток", "Підмет + Допоміжне дієслово + not + Присудок + Додаток", "Присудок + Підмет + Додаток", "Підмет + Додаток + Присудок"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Однина та множина іменників",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Однина та множина іменників</b><br>\n" +
                                    "В англійській мові множина іменників зазвичай утворюється шляхом додавання закінчення <b>-s</b> або <b>-es</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Правила утворення множини:</b><br>\n" +
                                    "- Додаємо <b>-s</b> до більшості іменників: <br>\n" +
                                    "  cat → cats, book → books, table → tables.<br>\n" +
                                    "- Додаємо <b>-es</b> до іменників, які закінчуються на <b>-s, -x, -ch, -sh, -o</b>:<br>\n" +
                                    "  box → boxes, church → churches, tomato → tomatoes.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється множина слова 'box'?",
                            options = listOf("boxs", "boxes", "boxies", "boxen"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Множина іменників, що закінчуються на -y</b><br>\n" +
                                    "- Якщо перед <b>-y</b> стоїть приголосна, змінюємо <b>-y</b> на <b>-ies</b>:<br>\n" +
                                    "  baby → babies, city → cities.<br>\n" +
                                    "- Якщо перед <b>-y</b> стоїть голосна, просто додаємо <b>-s</b>:<br>\n" +
                                    "  boy → boys, day → days.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється множина слова 'baby'?",
                            options = listOf("babys", "babyes", "babies", "babys'"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Неправильні форми множини</b><br>\n" +
                                    "Деякі іменники мають неправильні форми множини:<br>\n" +
                                    "- man → men, woman → women, child → children.<br>\n" +
                                    "- tooth → teeth, foot → feet, mouse → mice.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна множина слова 'child'?",
                            options = listOf("childs", "childes", "childrens", "children"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>Іменники, що не змінюються у множині</b><br>\n" +
                                    "Деякі іменники мають однакову форму в однині та множині:<br>\n" +
                                    "- sheep → sheep, deer → deer, fish → fish.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово має однакову форму в однині та множині?",
                            options = listOf("dog", "sheep", "house", "table"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Присвійні займенники",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Присвійні займенники</b><br>\n" +
                                    "Присвійні займенники (possessive pronouns) вказують на належність предмета особі.<br>\n" +
                                    "В англійській мові є два типи присвійних займенників:<br>\n" +
                                    "1. <b>Присвійні прикметники</b> (йдуть перед іменником):<br>\n" +
                                    "   - my (мій), your (твій/ваш), his (його), her (її), its (його/її - для предметів), our (наш), their (їхній).<br>\n" +
                                    "   <b>Приклад:</b> This is <b>my</b> book.<br>\n" +
                                    "<br>\n" +
                                    "2. <b>Присвійні займенники</b> (вживаються самостійно без іменника):<br>\n" +
                                    "   - mine (мій), yours (твій/ваш), his (його), hers (її), its (його/її - для предметів), ours (наш), theirs (їхній).<br>\n" +
                                    "   <b>Приклад:</b> This book is <b>mine</b>.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який присвійний займенник слід використати у фразі 'This is ... pen'?",
                            options = listOf("mine", "my", "me", "his"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Відмінності між присвійними прикметниками та займенниками</b><br>\n" +
                                    "- Присвійні прикметники завжди стоять перед іменником: <b>This is her bag.</b><br>\n" +
                                    "- Присвійні займенники використовуються самостійно: <b>This bag is hers.</b><br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який варіант правильний?",
                            options = listOf("This is your.", "This book is mine.", "This is hers book.", "This is me book."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Присвійні займенники не потребують артиклів</b><br>\n" +
                                    "В англійській мові перед присвійними займенниками не вживаються артиклі.<br>\n" +
                                    "<b>Неправильно:</b> This is <b>the</b> mine.<br>\n" +
                                    "<b>Правильно:</b> This is <b>mine</b>.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке з речень є правильним?",
                            options = listOf("This is the mine.", "This is mine.", "This is a mine.", "This is me."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Вказівні займенники",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Вказівні займенники</b><br>\n" +
                                    "Вказівні займенники (demonstrative pronouns) вказують на конкретний предмет або групу предметів.<br>\n" +
                                    "В англійській мові є чотири основних вказівних займенники:<br>\n" +
                                    "<br>\n" +
                                    "- <b>this</b> – цей, ця (для одного предмета, який знаходиться поруч).<br>\n" +
                                    "- <b>that</b> – той, та (для одного предмета, який знаходиться далеко).<br>\n" +
                                    "- <b>these</b> – ці (для множини, предмети знаходяться поруч).<br>\n" +
                                    "- <b>those</b> – ті (для множини, предмети знаходяться далеко).<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This is my phone. (Це мій телефон.)<br>\n" +
                                    "- That is your car. (То твоя машина.)<br>\n" +
                                    "- These are my keys. (Це мої ключі.)<br>\n" +
                                    "- Those are your shoes. (То твоє взуття.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який вказівний займенник слід використати для позначення об'єкта поблизу?",
                            options = listOf("this", "that", "those", "them"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Вказівні займенники у питальних реченнях</b><br>\n" +
                                    "Вказівні займенники можна використовувати у питальних реченнях:<br>\n" +
                                    "- What is <b>this</b>? (Що це?)<br>\n" +
                                    "- Who is <b>that</b>? (Хто це?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який вказівний займенник використовується у фразі 'Who is ...?'",
                            options = listOf("these", "that", "those", "this"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Вказівні займенники у множині</b><br>\n" +
                                    "Якщо предметів більше одного, потрібно використовувати 'these' або 'those'.<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- Are <b>these</b> your books? (Це твої книги?)<br>\n" +
                                    "- <b>Those</b> were my friends. (То були мої друзі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який вказівний займенник використовується для множини?",
                            options = listOf("this", "that", "these", "it"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Неозначені займенники",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Неозначені займенники</b><br>\n" +
                                    "Неозначені займенники (indefinite pronouns) використовуються, коли ми говоримо про невизначену кількість людей, речей або місць.<br>\n" +
                                    "<br>\n" +
                                    "<b>Основні групи неозначених займенників:</b><br>\n" +
                                    "<b>1. Займенники з -some, -any, -no:</b><br>\n" +
                                    "- <b>some</b>, <b>somebody</b>, <b>someone</b>, <b>something</b> – вживаються у стверджувальних реченнях.<br>\n" +
                                    "- <b>any</b>, <b>anybody</b>, <b>anyone</b>, <b>anything</b> – вживаються у питальних і заперечних реченнях.<br>\n" +
                                    "- <b>no</b>, <b>nobody</b>, <b>no one</b>, <b>nothing</b> – означають відсутність чогось.<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I see <b>someone</b> outside. (Я бачу когось на вулиці.)<br>\n" +
                                    "- Do you have <b>anything</b> to eat? (У тебе є щось поїсти?)<br>\n" +
                                    "- There is <b>nothing</b> in my bag. (У моїй сумці нічого немає.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який займенник слід використати у запитанні?",
                            options = listOf("somebody", "anybody", "nobody", "nothing"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Займенники з -every:</b><br>\n" +
                                    "- <b>every</b>, <b>everybody</b>, <b>everyone</b>, <b>everything</b> – означають усіх або все.<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Everybody</b> likes ice cream. (Усі люблять морозиво.)<br>\n" +
                                    "- <b>Everything</b> is ready. (Все готово.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який займенник означає 'все'?",
                            options = listOf("something", "anything", "everything", "nothing"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Інші неозначені займенники:</b><br>\n" +
                                    "- <b>one</b> (хтось, будь-хто): <b>One</b> should always be polite. (Завжди потрібно бути ввічливим.)<br>\n" +
                                    "- <b>each</b> (кожен): <b>Each</b> student has a book. (Кожен студент має книгу.)<br>\n" +
                                    "- <b>either</b> (будь-який з двох): You can take <b>either</b> seat. (Можеш сісти на будь-яке з двох місць.)<br>\n" +
                                    "- <b>neither</b> (жоден з двох): <b>Neither</b> answer is correct. (Жодна з двох відповідей не правильна.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'either'?",
                            options = listOf("ні той, ні інший", "кожен", "будь-який з двох", "все"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Дієслово 'to be'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Дієслово 'to be'</b><br>\n" +
                                    "Дієслово <b>'to be'</b> є одним із найважливіших в англійській мові. Воно означає 'бути, знаходитися' та змінюється залежно від особи та часу.<br>\n" +
                                    "<br>\n" +
                                    "<b>Форми 'to be' у Present Simple:</b><br>\n" +
                                    "- I <b>am</b> (Я є)<br>\n" +
                                    "- You <b>are</b> (Ти є/Ви є)<br>\n" +
                                    "- He/She/It <b>is</b> (Він/Вона/Воно є)<br>\n" +
                                    "- We/You/They <b>are</b> (Ми/Ви/Вони є)<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>am</b> a student. (Я – студент.)<br>\n" +
                                    "- She <b>is</b> my friend. (Вона – моя подруга.)<br>\n" +
                                    "- They <b>are</b> at home. (Вони вдома.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка форма 'to be' використовується з 'he' у Present Simple?",
                            options = listOf("am", "is", "are", "be"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечна форма 'to be' у Present Simple</b><br>\n" +
                                    "Заперечення утворюється додаванням <b>not</b> після 'to be':<br>\n" +
                                    "- I am <b>not</b> happy.<br>\n" +
                                    "- She is <b>not</b> at school.<br>\n" +
                                    "- They are <b>not</b> ready.<br>\n" +
                                    "<br>\n" +
                                    "Скорочені форми:<br>\n" +
                                    "- I'm not, he isn't, she isn't, it isn't, we aren't, you aren't, they aren't.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як виглядає скорочена форма 'She is not'?",
                            options = listOf("She am not", "She is'nt", "She isn't", "She not"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення з 'to be'</b><br>\n" +
                                    "У питальних реченнях дієслово 'to be' ставиться перед підметом:<br>\n" +
                                    "- <b>Am</b> I late? (Я запізнився?)<br>\n" +
                                    "- <b>Is</b> she your friend? (Вона твоя подруга?)<br>\n" +
                                    "- <b>Are</b> they at work? (Вони на роботі?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання з 'to be'?",
                            options = listOf("You are happy?", "Are you happy?", "You happy are?", "Happy are you?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Форми 'to be' у Past Simple</b><br>\n" +
                                    "У минулому часі 'to be' має дві форми:<br>\n" +
                                    "- I, he, she, it <b>was</b> (був, була, було)<br>\n" +
                                    "- We, you, they <b>were</b> (були)<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>was</b> at home yesterday. (Я був удома вчора.)<br>\n" +
                                    "- They <b>were</b> in the park. (Вони були в парку.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка форма 'to be' використовується з 'we' у Past Simple?",
                            options = listOf("was", "were", "is", "are"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "Дієслово 'to have'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Дієслово 'to have'</b><br>\n" +
                                    "Дієслово <b>'to have'</b> означає 'мати' або 'володіти' і використовується для позначення належності або стану.<br>\n" +
                                    "<br>\n" +
                                    "<b>Форми 'to have' у Present Simple:</b><br>\n" +
                                    "- I/You/We/They <b>have</b> (Я/Ти/Ми/Вони мають)<br>\n" +
                                    "- He/She/It <b>has</b> (Він/Вона/Воно має)<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>have</b> a car. (У мене є машина.)<br>\n" +
                                    "- She <b>has</b> a cat. (У неї є кіт.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка форма 'to have' використовується з 'he' у Present Simple?",
                            options = listOf("have", "has", "having", "had"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечна форма 'to have' у Present Simple</b><br>\n" +
                                    "Заперечення утворюється за допомогою 'do not' або 'does not':<br>\n" +
                                    "- I/You/We/They <b>do not have</b> (haven't) a car.<br>\n" +
                                    "- He/She/It <b>does not have</b> (doesn't have) a cat.<br>\n" +
                                    "<br>\n" +
                                    "Скорочені форми:<br>\n" +
                                    "- I don't have, he doesn't have, she doesn't have.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як виглядає правильна заперечна форма для 'she'?",
                            options = listOf("She does not has", "She don't have", "She does not have", "She hasn't"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення з 'to have'</b><br>\n" +
                                    "У питальних реченнях використовується допоміжне дієслово 'do' або 'does':<br>\n" +
                                    "- <b>Do</b> you have a bike? (У тебе є велосипед?)<br>\n" +
                                    "- <b>Does</b> she have a pet? (У неї є домашня тварина?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання з 'to have' у третій особі однини?",
                            options = listOf("Has she a pet?", "Does she has a pet?", "Does she have a pet?", "Do she have a pet?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Форми 'to have' у Past Simple</b><br>\n" +
                                    "У минулому часі 'to have' має тільки одну форму:<br>\n" +
                                    "- I/You/He/She/It/We/They <b>had</b> (мав/мали).<br>\n" +
                                    "<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>had</b> a great time. (Я чудово провів час.)<br>\n" +
                                    "- They <b>had</b> lunch at 2 PM. (Вони пообідали о 2 годині.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка форма 'to have' використовується у минулому часі?",
                            options = listOf("has", "have", "had", "having"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Звичайні та неправильні дієслова",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Звичайні та неправильні дієслова</b><br>\n" +
                                    "В англійській мові є два типи дієслів: <b>звичайні (regular)</b> та <b>неправильні (irregular)</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Звичайні дієслова</b><br>\n" +
                                    "Звичайні дієслова утворюють минулий час (Past Simple) і дієприкметник минулого часу (Past Participle) за допомогою закінчення <b>-ed</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- work → worked → worked (працювати)<br>\n" +
                                    "- play → played → played (грати)<br>\n" +
                                    "- visit → visited → visited (відвідувати)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється Past Simple для звичайних дієслів?",
                            options = listOf("Додаванням -ed", "Додаванням -ing", "Зміною кореня", "Без змін"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Правила додавання -ed</b><br>\n" +
                                    "- Якщо дієслово закінчується на <b>-e</b>, додається тільки <b>-d</b>:<br>\n" +
                                    "  love → loved, live → lived.<br>\n" +
                                    "- Якщо дієслово закінчується на приголосну + <b>y</b>, 'y' змінюється на <b>-ied</b>:<br>\n" +
                                    "  study → studied, try → tried.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється Past Simple для слова 'study'?",
                            options = listOf("studied", "studyes", "studyed", "studi"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Неправильні дієслова</b><br>\n" +
                                    "Неправильні дієслова не підкоряються загальним правилам і мають свої власні форми.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- go → went → gone (йти)<br>\n" +
                                    "- see → saw → seen (бачити)<br>\n" +
                                    "- take → took → taken (брати)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка форма Past Simple для слова 'go'?",
                            options = listOf("goed", "went", "goes", "gon"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Список найважливіших неправильних дієслів:</b><br>\n" +
                                    "- be → was/were → been<br>\n" +
                                    "- have → had → had<br>\n" +
                                    "- do → did → done<br>\n" +
                                    "- make → made → made<br>\n" +
                                    "- know → knew → known<br>\n" +
                                    "- get → got → gotten (амер.) / got (брит.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка третя форма (Past Participle) для слова 'know'?",
                            options = listOf("knew", "knowed", "known", "knows"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Модальні дієслова",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Модальні дієслова</b><br>\n" +
                                    "Модальні дієслова (modal verbs) – це спеціальні дієслова, які виражають можливість, необхідність, дозвіл, обов'язок тощо.<br>\n" +
                                    "Основні модальні дієслова в англійській мові:<br>\n" +
                                    "- <b>can</b> (можу, вмію)<br>\n" +
                                    "- <b>must</b> (повинен)<br>\n" +
                                    "- <b>should</b> (слід, варто)<br>\n" +
                                    "- <b>may</b> (можна, ймовірно)<br>\n" +
                                    "- <b>might</b> (можливо)<br>\n" +
                                    "- <b>could</b> (міг, міг би)<br>\n" +
                                    "- <b>would</b> (би)<br>\n" +
                                    "- <b>shall</b> (повинен, формальна форма)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке модальне дієслово використовується для вираження дозволу?",
                            options = listOf("must", "can", "should", "will"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Модальне дієслово 'can'</b><br>\n" +
                                    "- Використовується для вираження можливості або здібностей:<br>\n" +
                                    "  - I <b>can</b> swim. (Я вмію плавати.)<br>\n" +
                                    "- Використовується для запиту дозволу:<br>\n" +
                                    "  - <b>Can</b> I go out? (Можна мені піти?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'can' у реченні 'I can swim'?",
                            options = listOf("Можливість", "Заборону", "Обов'язок", "Пропозицію"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Модальне дієслово 'must'</b><br>\n" +
                                    "- Виражає обов'язок або необхідність:<br>\n" +
                                    "  - You <b>must</b> wear a seatbelt. (Ти повинен пристебнути ремінь безпеки.)<br>\n" +
                                    "- Виражає сильну впевненість:<br>\n" +
                                    "  - She <b>must</b> be at home now. (Вона, мабуть, зараз удома.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що виражає 'must' у реченні 'You must study'?",
                            options = listOf("Пропозицію", "Заборону", "Обов'язок", "Ймовірність"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Модальне дієслово 'should'</b><br>\n" +
                                    "- Використовується для порад або рекомендацій:<br>\n" +
                                    "  - You <b>should</b> eat more vegetables. (Тобі слід їсти більше овочів.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке модальне дієслово використовується для поради?",
                            options = listOf("could", "should", "must", "might"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Відмінності між 'must' та 'have to'</b><br>\n" +
                                    "- 'Must' означає обов’язок, що йде від самого мовця.<br>\n" +
                                    "  - I <b>must</b> finish my work. (Я повинен закінчити свою роботу.)<br>\n" +
                                    "- 'Have to' означає обов’язок, накладений зовнішніми обставинами.<br>\n" +
                                    "  - I <b>have to</b> wake up early for work. (Мені доводиться вставати рано через роботу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке модальне дієслово виражає обов'язок, накладений зовнішніми обставинами?",
                            options = listOf("must", "should", "can", "have to"),
                            correctAnswerIndex = 3
                        )
                    )
                ),
                Lesson(
                    id = 13,
                    title = "Розділ 13",
                    topic = "Present Simple",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Час Present Simple</b><br>\n" +
                                    "Present Simple (простий теперішній час) використовується для вираження звичних дій, фактів і загальних істин.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула утворення:</b><br>\n" +
                                    "- Для I, You, We, They: <b>підмет + основна форма дієслова</b><br>\n" +
                                    "  - I <b>work</b>. (Я працюю.)<br>\n" +
                                    "- Для He, She, It: <b>підмет + основна форма дієслова + -s/-es</b><br>\n" +
                                    "  - She <b>works</b>. (Вона працює.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна форма дієслова для 'he' у Present Simple?",
                            options = listOf("work", "works", "working", "worked"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання Present Simple:</b><br>\n" +
                                    "1. Регулярні або повторювані дії:<br>\n" +
                                    "  - I <b>go</b> to school every day. (Я ходжу до школи кожен день.)<br>\n" +
                                    "2. Загальні істини або факти:<br>\n" +
                                    "  - The sun <b>rises</b> in the east. (Сонце сходить на сході.)<br>\n" +
                                    "3. Розклади та графіки:<br>\n" +
                                    "  - The train <b>leaves</b> at 5 PM. (Поїзд відправляється о 17:00.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення вжите у Present Simple?",
                            options = listOf("She is running now.", "She runs every morning.", "She will run tomorrow.", "She ran yesterday."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечення у Present Simple</b><br>\n" +
                                    "- Для I, You, We, They: <b>do not (don’t) + основне дієслово</b><br>\n" +
                                    "  - I <b>do not like</b> coffee. (Мені не подобається кава.)<br>\n" +
                                    "- Для He, She, It: <b>does not (doesn’t) + основне дієслово</b><br>\n" +
                                    "  - She <b>does not play</b> football. (Вона не грає у футбол.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна заперечна форма для 'they'?",
                            options = listOf("They does not work.", "They do not work.", "They working not.", "They don't works."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення у Present Simple</b><br>\n" +
                                    "- Для I, You, We, They: <b>Do + підмет + основне дієслово?</b><br>\n" +
                                    "  - <b>Do</b> you like music? (Тобі подобається музика?)<br>\n" +
                                    "- Для He, She, It: <b>Does + підмет + основне дієслово?</b><br>\n" +
                                    "  - <b>Does</b> he play football? (Він грає у футбол?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання у Present Simple?",
                            options = listOf("Do she like coffee?", "Does she likes coffee?", "Does she like coffee?", "She does like coffee?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Маркерні слова для Present Simple:</b><br>\n" +
                                    "- always (завжди), usually (зазвичай), often (часто), sometimes (іноді), never (ніколи), every day (щодня).<br>\n" +
                                    "<b>Приклад:</b> He <b>always</b> wakes up early. (Він завжди прокидається рано.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово є маркером для Present Simple?",
                            options = listOf("now", "yesterday", "every day", "tomorrow"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 14,
                    title = "Розділ 14",
                    topic = "Present Continuous",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Час Present Continuous</b><br>\n" +
                                    "Present Continuous (теперішній тривалий час) використовується для вираження дій, що відбуваються у момент мовлення або мають тимчасовий характер.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула утворення:</b><br>\n" +
                                    "- <b>Підмет + am/is/are + дієслово + -ing</b><br>\n" +
                                    "  - I <b>am reading</b>. (Я зараз читаю.)<br>\n" +
                                    "  - She <b>is studying</b>. (Вона зараз навчається.)<br>\n" +
                                    "  - They <b>are playing</b>. (Вони зараз грають.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна форма дієслова для 'they' у Present Continuous?",
                            options = listOf("is playing", "are playing", "am playing", "playing"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання Present Continuous:</b><br>\n" +
                                    "1. Дії, що відбуваються у момент мовлення:<br>\n" +
                                    "  - She <b>is talking</b> on the phone now. (Вона зараз розмовляє по телефону.)<br>\n" +
                                    "2. Тимчасові ситуації:<br>\n" +
                                    "  - I <b>am working</b> on a new project. (Я зараз працюю над новим проєктом.)<br>\n" +
                                    "3. Заплановані дії у майбутньому:<br>\n" +
                                    "  - We <b>are meeting</b> tomorrow. (Ми зустрічаємося завтра.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Present Continuous?",
                            options = listOf("Для загальних істин", "Для дій, що відбуваються зараз", "Для минулих подій", "Для звичок"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечення у Present Continuous</b><br>\n" +
                                    "- Заперечення утворюється додаванням 'not' після am/is/are:<br>\n" +
                                    "  - I <b>am not working</b>. (Я не працюю.)<br>\n" +
                                    "  - She <b>is not watching</b> TV. (Вона не дивиться телевізор.)<br>\n" +
                                    "  - They <b>are not sleeping</b>. (Вони не сплять.)<br>\n" +
                                    "<br>\n" +
                                    "Скорочені форми:<br>\n" +
                                    "- I’m not, he/she/it isn’t, we/you/they aren’t.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке заперечення правильне для 'she' у Present Continuous?",
                            options = listOf("She are not sleeping", "She is not sleeping", "She do not sleeping", "She does not sleeping"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення у Present Continuous</b><br>\n" +
                                    "- Запитання утворюється перестановкою am/is/are перед підметом:<br>\n" +
                                    "  - <b>Am</b> I speaking? (Я зараз говорю?)<br>\n" +
                                    "  - <b>Is</b> he studying? (Він зараз навчається?)<br>\n" +
                                    "  - <b>Are</b> they coming? (Вони йдуть?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання у Present Continuous?",
                            options = listOf("She is working?", "Is she working?", "Working she is?", "She working is?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Маркерні слова для Present Continuous:</b><br>\n" +
                                    "- now (зараз), at the moment (в цей момент), currently (наразі), today (сьогодні), this week (цього тижня).<br>\n" +
                                    "<b>Приклад:</b> They <b>are studying</b> English now. (Вони зараз вивчають англійську.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово є маркером для Present Continuous?",
                            options = listOf("yesterday", "now", "always", "tomorrow"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 15,
                    title = "Розділ 15",
                    topic = "Past Simple",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Час Past Simple</b><br>\n" +
                                    "Past Simple (минулий простий час) використовується для вираження завершених дій, що відбулися у минулому.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула утворення:</b><br>\n" +
                                    "- Для звичайних дієслів: <b>підмет + дієслово + -ed</b><br>\n" +
                                    "  - I <b>worked</b> yesterday. (Я працював учора.)<br>\n" +
                                    "- Для неправильних дієслів: <b>підмет + друга форма дієслова</b><br>\n" +
                                    "  - She <b>went</b> to school. (Вона пішла до школи.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється Past Simple для правильних дієслів?",
                            options = listOf("Додаванням -ed", "Додаванням -ing", "Зміною кореня", "Без змін"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання Past Simple:</b><br>\n" +
                                    "1. Дії, що відбулися у певний момент у минулому:<br>\n" +
                                    "  - I <b>met</b> him last week. (Я зустрів його минулого тижня.)<br>\n" +
                                    "2. Послідовність дій у минулому:<br>\n" +
                                    "  - She <b>came</b> home, <b>cooked</b> dinner and <b>went</b> to bed. (Вона прийшла додому, приготувала вечерю і пішла спати.)<br>\n" +
                                    "3. Факти або ситуації у минулому:<br>\n" +
                                    "  - He <b>was</b> a teacher ten years ago. (Він був учителем десять років тому.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення вжите у Past Simple?",
                            options = listOf("She is reading now.", "She reads every morning.", "She will read tomorrow.", "She read yesterday."),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечення у Past Simple</b><br>\n" +
                                    "- Заперечення утворюється за допомогою 'did not (didn't)' + основна форма дієслова:<br>\n" +
                                    "  - I <b>did not</b> go to the party. (Я не ходив на вечірку.)<br>\n" +
                                    "  - She <b>didn't</b> like the movie. (Їй не сподобався фільм.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна заперечна форма для 'they' у Past Simple?",
                            options = listOf("They didn't went.", "They don't go.", "They didn't go.", "They not go."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення у Past Simple</b><br>\n" +
                                    "- Запитання утворюється за допомогою 'Did' + підмет + основна форма дієслова:<br>\n" +
                                    "  - <b>Did</b> you watch TV yesterday? (Ти дивився телевізор учора?)<br>\n" +
                                    "  - <b>Did</b> she call you? (Вона тобі зателефонувала?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання у Past Simple?",
                            options = listOf("Did she called?", "Did she call?", "She did call?", "She call did?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Маркерні слова для Past Simple:</b><br>\n" +
                                    "- yesterday (учора), last week (минулого тижня), two days ago (два дні тому), in 2010 (у 2010 році).<br>\n" +
                                    "<b>Приклад:</b> They <b>went</b> to Paris last summer. (Вони поїхали в Париж минулого літа.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово є маркером для Past Simple?",
                            options = listOf("tomorrow", "already", "yesterday", "now"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 16,
                    title = "Розділ 16",
                    topic = "Future Simple",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Час Future Simple</b><br>\n" +
                                    "Future Simple (простий майбутній час) використовується для вираження дій, що відбудуться у майбутньому.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула утворення:</b><br>\n" +
                                    "- <b>Підмет + will + основна форма дієслова</b><br>\n" +
                                    "  - I <b>will call</b> you tomorrow. (Я зателефоную тобі завтра.)<br>\n" +
                                    "  - She <b>will study</b> hard. (Вона буде старанно вчитися.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється Future Simple?",
                            options = listOf("Підмет + will + дієслово", "Підмет + was/were + дієслово", "Підмет + had + дієслово", "Підмет + does + дієслово"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання Future Simple:</b><br>\n" +
                                    "1. Дії, що відбудуться у майбутньому:<br>\n" +
                                    "  - She <b>will arrive</b> at 5 PM. (Вона прибуде о 17:00.)<br>\n" +
                                    "2. Спонтанні рішення:<br>\n" +
                                    "  - I <b>will help</b> you with your homework. (Я допоможу тобі з домашнім завданням.)<br>\n" +
                                    "3. Прогнози, припущення:<br>\n" +
                                    "  - It <b>will rain</b> tomorrow. (Завтра буде дощ.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Future Simple?",
                            options = listOf("Для фактів", "Для дій, що відбуваються зараз", "Для спонтанних рішень", "Для звичних дій"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечення у Future Simple</b><br>\n" +
                                    "- Заперечення утворюється за допомогою 'will not (won't)' + основна форма дієслова:<br>\n" +
                                    "  - I <b>will not</b> be late. (Я не запізнюся.)<br>\n" +
                                    "  - She <b>won't</b> go to the party. (Вона не піде на вечірку.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна заперечна форма Future Simple?",
                            options = listOf("He will doesn't go.", "He not will go.", "He will not go.", "He does not will go."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні речення у Future Simple</b><br>\n" +
                                    "- Запитання утворюється за допомогою 'Will' перед підметом:<br>\n" +
                                    "  - <b>Will</b> you help me? (Ти допоможеш мені?)<br>\n" +
                                    "  - <b>Will</b> they come tomorrow? (Вони прийдуть завтра?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно задати запитання у Future Simple?",
                            options = listOf("Will she go?", "She will go?", "Does she will go?", "She will going?"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Маркерні слова для Future Simple:</b><br>\n" +
                                    "- tomorrow (завтра), next week (наступного тижня), in a year (через рік), soon (скоро), one day (одного дня).<br>\n" +
                                    "<b>Приклад:</b> We <b>will travel</b> to Italy next summer. (Ми поїдемо в Італію наступного літа.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово є маркером для Future Simple?",
                            options = listOf("yesterday", "now", "tomorrow", "already"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 17,
                    title = "Розділ 17",
                    topic = "Питальні слова (who, what, where, when, why, how)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Питальні слова в англійській мові</b><br>\n" +
                                    "Питальні слова (question words) використовуються для формування запитань.<br>\n" +
                                    "Основні питальні слова:<br>\n" +
                                    "<br>\n" +
                                    "- <b>Who</b> – хто?<br>\n" +
                                    "- <b>What</b> – що? який?<br>\n" +
                                    "- <b>Where</b> – де? куди?<br>\n" +
                                    "- <b>When</b> – коли?<br>\n" +
                                    "- <b>Why</b> – чому? навіщо?<br>\n" +
                                    "- <b>How</b> – як?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке питальне слово використовується для запитання про місце?",
                            options = listOf("Who", "What", "Where", "When"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Приклади використання питальних слів:</b><br>\n" +
                                    "- <b>Who</b> is your best friend? (Хто твій найкращий друг?)<br>\n" +
                                    "- <b>What</b> do you like to eat? (Що тобі подобається їсти?)<br>\n" +
                                    "- <b>Where</b> do you live? (Де ти живеш?)<br>\n" +
                                    "- <b>When</b> is your birthday? (Коли твій день народження?)<br>\n" +
                                    "- <b>Why</b> are you sad? (Чому ти сумний?)<br>\n" +
                                    "- <b>How</b> do you get to school? (Як ти добираєшся до школи?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке питальне слово використовується для запитання про причину?",
                            options = listOf("What", "When", "Why", "How"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Додаткові питальні слова:</b><br>\n" +
                                    "- <b>Which</b> – який із?<br>\n" +
                                    "- <b>Whose</b> – чий?<br>\n" +
                                    "- <b>How much</b> – скільки? (незлічувані)<br>\n" +
                                    "- <b>How many</b> – скільки? (злічувані)<br>\n" +
                                    "- <b>How long</b> – як довго?<br>\n" +
                                    "- <b>How often</b> – як часто?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке питальне слово використовується для запитання про вибір між варіантами?",
                            options = listOf("Whose", "Which", "Where", "How"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Питальні слова та порядок слів у питальних реченнях:</b><br>\n" +
                                    "- Питальне слово + допоміжне дієслово + підмет + присудок:<br>\n" +
                                    "  - <b>Where</b> do you work? (Де ти працюєш?)<br>\n" +
                                    "  - <b>Why</b> are you late? (Чому ти запізнився?)<br>\n" +
                                    "- Якщо питальне слово є підметом, допоміжне дієслово не потрібне:<br>\n" +
                                    "  - <b>Who</b> knows the answer? (Хто знає відповідь?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який правильний порядок слів у питальному реченні?",
                            options = listOf("Підмет + питальне слово + присудок", "Питальне слово + допоміжне дієслово + підмет + присудок", "Присудок + підмет + питальне слово", "Підмет + допоміжне дієслово + питальне слово + присудок"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 18,
                    title = "Розділ 18",
                    topic = "Запитання в Present Simple (Do/Does)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Запитання в Present Simple</b><br>\n" +
                                    "У Present Simple для утворення питальних речень використовуються допоміжні дієслова <b>do</b> та <b>does</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула запитання:</b><br>\n" +
                                    "- <b>Do</b> + підмет + основна форма дієслова?<br>\n" +
                                    "  - <b>Do</b> you like pizza? (Тобі подобається піца?)<br>\n" +
                                    "- <b>Does</b> + підмет + основна форма дієслова?<br>\n" +
                                    "  - <b>Does</b> she play tennis? (Вона грає у теніс?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке допоміжне дієслово використовується у питанні для 'he'?",
                            options = listOf("Do", "Does", "Did", "Will"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання 'Do' та 'Does':</b><br>\n" +
                                    "- 'Do' використовується з I, you, we, they:<br>\n" +
                                    "  - <b>Do</b> they work here? (Вони тут працюють?)<br>\n" +
                                    "- 'Does' використовується з he, she, it:<br>\n" +
                                    "  - <b>Does</b> he study English? (Він вивчає англійську?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "З якими займенниками використовується 'does'?",
                            options = listOf("I, you, we, they", "he, she, it", "we, they", "I, she, they"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Відповіді на запитання:</b><br>\n" +
                                    "- Короткі стверджувальні відповіді:<br>\n" +
                                    "  - Yes, I <b>do</b>. / Yes, she <b>does</b>.<br>\n" +
                                    "- Короткі заперечні відповіді:<br>\n" +
                                    "  - No, I <b>don’t</b>. / No, he <b>doesn’t</b>.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна коротка відповідь на 'Does she like coffee?'",
                            options = listOf("Yes, she do.", "Yes, she does.", "Yes, she like.", "Yes, she doesn't."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Запитання з питальними словами</b><br>\n" +
                                    "- Порядок слів: питальне слово + do/does + підмет + дієслово:<br>\n" +
                                    "  - <b>Where</b> do you live? (Де ти живеш?)<br>\n" +
                                    "  - <b>What</b> does she do? (Чим вона займається?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити питання з 'Where' у Present Simple?",
                            options = listOf("Where you do live?", "Where do you live?", "Where does live you?", "Where you does live?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 19,
                    title = "Розділ 19",
                    topic = "Запитання в Past Simple (Did)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Запитання в Past Simple</b><br>\n" +
                                    "У Past Simple для утворення питальних речень використовується допоміжне дієслово <b>did</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Формула запитання:</b><br>\n" +
                                    "- <b>Did</b> + підмет + основна форма дієслова?<br>\n" +
                                    "  - <b>Did</b> you go to school yesterday? (Ти ходив до школи вчора?)<br>\n" +
                                    "  - <b>Did</b> she call you? (Вона тобі зателефонувала?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке допоміжне дієслово використовується у питанні в Past Simple?",
                            options = listOf("Do", "Does", "Did", "Will"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Правило:</b> Після 'Did' основне дієслово завжди залишається у <b>початковій формі</b>, а не в минулій!<br>\n" +
                                    "<b>Неправильно:</b> Did you <b>went</b> home?<br>\n" +
                                    "<b>Правильно:</b> Did you <b>go</b> home?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна форма речення в Past Simple?",
                            options = listOf("Did he went?", "Did he goes?", "Did he go?", "Did he going?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Відповіді на запитання:</b><br>\n" +
                                    "- Короткі стверджувальні відповіді:<br>\n" +
                                    "  - Yes, I <b>did</b>. / Yes, she <b>did</b>.<br>\n" +
                                    "- Короткі заперечні відповіді:<br>\n" +
                                    "  - No, I <b>didn't</b>. / No, he <b>didn’t</b>.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна коротка відповідь на 'Did she like the movie?'",
                            options = listOf("Yes, she do.", "Yes, she did.", "Yes, she does.", "Yes, she didn't."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Запитання з питальними словами</b><br>\n" +
                                    "- Порядок слів: питальне слово + did + підмет + дієслово:<br>\n" +
                                    "  - <b>Where</b> did you go? (Куди ти ходив?)<br>\n" +
                                    "  - <b>What</b> did she say? (Що вона сказала?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити питання з 'What' у Past Simple?",
                            options = listOf("What she did say?", "What did she say?", "What does she say?", "What do she say?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 20,
                    title = "Розділ 20",
                    topic = "Заперечні речення (don’t, doesn’t, didn’t)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Заперечні речення в англійській мові</b><br>\n" +
                                    "У Present Simple та Past Simple заперечення утворюється за допомогою допоміжних дієслів <b>do/does + not</b> або <b>did + not</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>Заперечення в Present Simple:</b><br>\n" +
                                    "- Для I, You, We, They: <b>do not (don’t) + основне дієслово</b><br>\n" +
                                    "  - I <b>don’t</b> like coffee. (Мені не подобається кава.)<br>\n" +
                                    "- Для He, She, It: <b>does not (doesn’t) + основне дієслово</b><br>\n" +
                                    "  - She <b>doesn’t</b> play tennis. (Вона не грає у теніс.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна заперечна форма для 'he' у Present Simple?",
                            options = listOf("He do not play", "He does not plays", "He does not play", "He don’t play"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Заперечення в Past Simple:</b><br>\n" +
                                    "- Для всіх осіб: <b>did not (didn’t) + основне дієслово</b><br>\n" +
                                    "  - They <b>didn’t</b> go to school. (Вони не ходили до школи.)<br>\n" +
                                    "  - She <b>didn’t</b> call me. (Вона не телефонувала мені.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна заперечна форма для 'she' у Past Simple?",
                            options = listOf("She didn’t called", "She didn’t call", "She don’t call", "She doesn’t call"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Важливе правило:</b><br>\n" +
                                    "- Після don’t, doesn’t і didn’t дієслово завжди залишається в <b>основній формі</b>!<br>\n" +
                                    "<b>Неправильно:</b> She doesn’t <b>likes</b> coffee.<br>\n" +
                                    "<b>Правильно:</b> She doesn’t <b>like</b> coffee.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке з речень є правильним?",
                            options = listOf("She doesn’t likes tea.", "She don’t like tea.", "She doesn’t like tea.", "She doesn’t liked tea."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Скорочені форми:</b><br>\n" +
                                    "- do not → don’t<br>\n" +
                                    "- does not → doesn’t<br>\n" +
                                    "- did not → didn’t<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- We <b>don’t</b> watch TV in the morning. (Ми не дивимося телевізор вранці.)<br>\n" +
                                    "- He <b>doesn’t</b> like chocolate. (Йому не подобається шоколад.)<br>\n" +
                                    "- I <b>didn’t</b> see that movie. (Я не бачив цей фільм.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна скорочена форма для 'do not'?",
                            options = listOf("doesn't", "don’t", "didn’t", "do'nt"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 21,
                    title = "Розділ 21",
                    topic = "Ступені порівняння прикметників (big, bigger, the biggest)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Ступені порівняння прикметників</b><br>\n" +
                                    "В англійській мові прикметники мають три ступені порівняння:<br>\n" +
                                    "1. <b>Початкова форма (Positive)</b> – використовується для опису якості предмета (big – великий).<br>\n" +
                                    "2. <b>Вищий ступінь (Comparative)</b> – використовується для порівняння двох предметів (bigger – більший).<br>\n" +
                                    "3. <b>Найвищий ступінь (Superlative)</b> – використовується для порівняння одного предмета з групою (the biggest – найбільший).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який ступінь порівняння використовується для порівняння двох предметів?",
                            options = listOf("Positive", "Comparative", "Superlative", "Basic"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Правила утворення вищого та найвищого ступенів:</b><br>\n" +
                                    "- <b>Короткі прикметники</b> (1 склад) додають <b>-er</b> у вищому та <b>-est</b> у найвищому ступені:<br>\n" +
                                    "  - big → bigger → the biggest<br>\n" +
                                    "  - small → smaller → the smallest<br>\n" +
                                    "- <b>Якщо прикметник закінчується на приголосну + голосну + приголосну, остання буква подвоюється:</b><br>\n" +
                                    "  - hot → hotter → the hottest<br>\n" +
                                    "  - fat → fatter → the fattest<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється вищий ступінь слова 'big'?",
                            options = listOf("biger", "bigerer", "bigger", "biggest"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Прикметники, що закінчуються на -y:</b><br>\n" +
                                    "- Якщо прикметник закінчується на -y після приголосної, -y змінюється на -i перед додаванням -er/-est:<br>\n" +
                                    "  - happy → happier → the happiest<br>\n" +
                                    "  - easy → easier → the easiest<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється найвищий ступінь прикметника 'happy'?",
                            options = listOf("happiest", "happyer", "happiestest", "happyiest"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Довгі прикметники (2 і більше склади)</b><br>\n" +
                                    "- Вищий ступінь: додаємо 'more' перед прикметником.<br>\n" +
                                    "- Найвищий ступінь: додаємо 'the most' перед прикметником.<br>\n" +
                                    "  - interesting → more interesting → the most interesting<br>\n" +
                                    "  - beautiful → more beautiful → the most beautiful<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється вищий ступінь прикметника 'beautiful'?",
                            options = listOf("beautifuller", "more beautiful", "beautifullest", "the beautifulest"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Неправильні форми порівняння прикметників</b><br>\n" +
                                    "- good → better → the best (добрий → кращий → найкращий)<br>\n" +
                                    "- bad → worse → the worst (поганий → гірший → найгірший)<br>\n" +
                                    "- far → farther/further → the farthest/the furthest (далекий → дальший → найдальший)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна вища форма прикметника 'good'?",
                            options = listOf("gooder", "more good", "better", "best"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 22,
                    title = "Розділ 22",
                    topic = "Прислівники способу дії (slowly, quickly, well, badly)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Прислівники способу дії</b><br>\n" +
                                    "Прислівники способу дії (adverbs of manner) описують, як відбувається дія.<br>\n" +
                                    "<br>\n" +
                                    "<b>Як утворюються прислівники?</b><br>\n" +
                                    "- Більшість прислівників утворюється шляхом додавання <b>-ly</b> до прикметника:<br>\n" +
                                    "  - slow → <b>slowly</b> (повільно)<br>\n" +
                                    "  - quick → <b>quickly</b> (швидко)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як утворюється прислівник від слова 'happy'?",
                            options = listOf("happily", "happyly", "happyness", "happying"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>Приклади використання прислівників:</b><br>\n" +
                                    "- She drives <b>carefully</b>. (Вона водить обережно.)<br>\n" +
                                    "- He speaks <b>fluently</b>. (Він говорить вільно.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прислівник описує спосіб виконання дії?",
                            options = listOf("quick", "quickly", "quicker", "quickest"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Неправильні прислівники</b><br>\n" +
                                    "Деякі прислівники мають неправильну форму:<br>\n" +
                                    "- good → <b>well</b> (добре)<br>\n" +
                                    "- bad → <b>badly</b> (погано)<br>\n" +
                                    "- fast → <b>fast</b> (швидко) (без -ly!)<br>\n" +
                                    "- hard → <b>hard</b> (важко) (без -ly!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна прислівникова форма для 'good'?",
                            options = listOf("goodly", "better", "well", "goodest"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Розташування прислівників у реченні</b><br>\n" +
                                    "- Прислівник зазвичай стоїть після дієслова:<br>\n" +
                                    "  - She sings <b>beautifully</b>. (Вона співає чудово.)<br>\n" +
                                    "- Якщо дієслово має додаток, прислівник ставиться після нього:<br>\n" +
                                    "  - He speaks English <b>fluently</b>. (Він вільно говорить англійською.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Де зазвичай стоїть прислівник способу дії у реченні?",
                            options = listOf("Перед дієсловом", "Після дієслова", "Перед підметом", "У кінці речення без правила"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 23,
                    title = "Розділ 23",
                    topic = "Місцезнаходження предметів (in, on, under, next to, between)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Прийменники місця</b><br>\n" +
                                    "Прийменники місця (prepositions of place) вказують, де знаходиться предмет у просторі.<br>\n" +
                                    "<br>\n" +
                                    "<b>Основні прийменники місця:</b><br>\n" +
                                    "- <b>in</b> – у, всередині:<br>\n" +
                                    "  - The books are <b>in</b> the bag. (Книги в сумці.)<br>\n" +
                                    "- <b>on</b> – на поверхні:<br>\n" +
                                    "  - The phone is <b>on</b> the table. (Телефон на столі.)<br>\n" +
                                    "- <b>under</b> – під:<br>\n" +
                                    "  - The cat is <b>under</b> the chair. (Кіт під стільцем.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник слід використати у фразі: 'The keys are ... the table'?",
                            options = listOf("in", "on", "under", "next to"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Додаткові прийменники місця:</b><br>\n" +
                                    "- <b>next to</b> – поруч:<br>\n" +
                                    "  - The school is <b>next to</b> the park. (Школа поруч із парком.)<br>\n" +
                                    "- <b>between</b> – між:<br>\n" +
                                    "  - The bank is <b>between</b> the post office and the café. (Банк між поштою та кафе.)<br>\n" +
                                    "- <b>behind</b> – позаду:<br>\n" +
                                    "  - The car is <b>behind</b> the house. (Машина позаду будинку.)<br>\n" +
                                    "- <b>in front of</b> – перед:<br>\n" +
                                    "  - The bus stop is <b>in front of</b> the supermarket. (Автобусна зупинка перед супермаркетом.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає 'між'?",
                            options = listOf("next to", "behind", "under", "between"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>Приклади використання прийменників місця:</b><br>\n" +
                                    "- The books are <b>on</b> the shelf. (Книги на полиці.)<br>\n" +
                                    "- The dog is <b>under</b> the table. (Собака під столом.)<br>\n" +
                                    "- The TV is <b>in front of</b> the sofa. (Телевізор перед диваном.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає 'перед'?",
                            options = listOf("behind", "in front of", "next to", "under"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 24,
                    title = "Розділ 24",
                    topic = "Порядкові числівники (first, second, third)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Порядкові числівники</b><br>\n" +
                                    "Порядкові числівники (ordinal numbers) вказують на порядок предметів у ряді (перший, другий, третій і т. д.).<br>\n" +
                                    "<br>\n" +
                                    "<b>Основні порядкові числівники:</b><br>\n" +
                                    "- 1st – <b>first</b> (перший)<br>\n" +
                                    "- 2nd – <b>second</b> (другий)<br>\n" +
                                    "- 3rd – <b>third</b> (третій)<br>\n" +
                                    "- 4th – <b>fourth</b> (четвертий)<br>\n" +
                                    "- 5th – <b>fifth</b> (п'ятий)<br>\n" +
                                    "- 6th – <b>sixth</b> (шостий)<br>\n" +
                                    "- 7th – <b>seventh</b> (сьомий)<br>\n" +
                                    "- 8th – <b>eighth</b> (восьмий)<br>\n" +
                                    "- 9th – <b>ninth</b> (дев'ятий)<br>\n" +
                                    "- 10th – <b>tenth</b> (десятий)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який порядковий числівник означає 'третій'?",
                            options = listOf("first", "second", "third", "fourth"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Порядкові числівники від 11 до 20:</b><br>\n" +
                                    "- 11th – <b>eleventh</b> (одинадцятий)<br>\n" +
                                    "- 12th – <b>twelfth</b> (дванадцятий)<br>\n" +
                                    "- 13th – <b>thirteenth</b> (тринадцятий)<br>\n" +
                                    "- 14th – <b>fourteenth</b> (чотирнадцятий)<br>\n" +
                                    "- 15th – <b>fifteenth</b> (п’ятнадцятий)<br>\n" +
                                    "- 20th – <b>twentieth</b> (двадцятий)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який порядковий числівник означає 'дванадцятий'?",
                            options = listOf("twentieth", "twelfth", "tenth", "eleventh"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Порядкові числівники після 20:</b><br>\n" +
                                    "Починаючи з 21, порядкові числівники утворюються додаванням 'st', 'nd', 'rd' або 'th' до кількісного числівника.<br>\n" +
                                    "<br>\n" +
                                    "- 21st – <b>twenty-first</b> (двадцять перший)<br>\n" +
                                    "- 22nd – <b>twenty-second</b> (двадцять другий)<br>\n" +
                                    "- 23rd – <b>twenty-third</b> (двадцять третій)<br>\n" +
                                    "- 24th – <b>twenty-fourth</b> (двадцять четвертий)<br>\n" +
                                    "- 30th – <b>thirtieth</b> (тридцятий)<br>\n" +
                                    "- 100th – <b>hundredth</b> (сотий)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно записати 'двадцять перший'?",
                            options = listOf("twenty-oneth", "twenty-one", "twenty-first", "twenty-once"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Вживання порядкових числівників:</b><br>\n" +
                                    "- В датах:<br>\n" +
                                    "  - Today is the <b>fifth</b> of May. (Сьогодні п'яте травня.)<br>\n" +
                                    "- Вказуючи порядок:<br>\n" +
                                    "  - She finished in <b>second</b> place. (Вона фінішувала другою.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно сказати 'сьоме лютого'?",
                            options = listOf("February the seventh", "Seven of February", "February seventh", "Seventh February"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 25,
                    title = "Розділ 25",
                    topic = "Прийменники місця (in, on, at)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Прийменники місця in, on, at</b><br>\n" +
                                    "Прийменники <b>in, on, at</b> вказують на місце розташування об'єкта.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Прийменник 'in' – у, всередині</b><br>\n" +
                                    "Використовується, коли щось знаходиться <b>всередині</b> певного простору.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The keys are <b>in</b> my bag. (Ключі в моїй сумці.)<br>\n" +
                                    "- She lives <b>in</b> London. (Вона живе в Лондоні.)<br>\n" +
                                    "- There are apples <b>in</b> the basket. (Є яблука в кошику.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник слід використати у фразі: 'The books are ... the bag'?",
                            options = listOf("on", "in", "at", "under"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Прийменник 'on' – на поверхні</b><br>\n" +
                                    "Використовується, коли предмет знаходиться <b>на поверхні</b> чогось.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The phone is <b>on</b> the table. (Телефон на столі.)<br>\n" +
                                    "- There is a picture <b>on</b> the wall. (На стіні є картина.)<br>\n" +
                                    "- The book is <b>on</b> the shelf. (Книга на полиці.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає, що щось знаходиться на поверхні?",
                            options = listOf("in", "on", "at", "by"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Прийменник 'at' – у конкретному місці</b><br>\n" +
                                    "Використовується, коли йдеться про <b>конкретне місце або точку</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- She is <b>at</b> the bus stop. (Вона на автобусній зупинці.)<br>\n" +
                                    "- We met <b>at</b> the cinema. (Ми зустрілися в кінотеатрі.)<br>\n" +
                                    "- He is <b>at</b> school. (Він у школі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає, що щось знаходиться у конкретному місці?",
                            options = listOf("in", "on", "at", "under"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Різниця між 'in', 'on' та 'at'</b><br>\n" +
                                    "- <b>In</b> – щось всередині об'єкта (in a box, in the city).<br>\n" +
                                    "- <b>On</b> – щось на поверхні (on the table, on the floor).<br>\n" +
                                    "- <b>At</b> – конкретне місце або точка (at the bus stop, at home).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник слід використати у фразі: 'She is ... home'?",
                            options = listOf("in", "on", "at", "under"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 26,
                    title = "Розділ 26",
                    topic = "Прийменники часу (in, on, at)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Прийменники часу: in, on, at</b><br>\n" +
                                    "Прийменники <b>in, on, at</b> використовуються для позначення часу.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Прийменник 'in' – для довгих періодів часу</b><br>\n" +
                                    "Використовується для позначення <b>місяців, років, століть, частин доби</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I was born <b>in</b> 1995. (Я народився у 1995 році.)<br>\n" +
                                    "- We will go on vacation <b>in</b> July. (Ми поїдемо у відпустку в липні.)<br>\n" +
                                    "- She drinks coffee <b>in</b> the morning. (Вона п'є каву вранці.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник слід використати у фразі: '... 2020, I started learning English'?",
                            options = listOf("in", "on", "at", "by"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Прийменник 'on' – для конкретних днів</b><br>\n" +
                                    "Використовується для позначення <b>днів тижня, дат, спеціальних подій</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I have a meeting <b>on</b> Monday. (У мене зустріч у понеділок.)<br>\n" +
                                    "- We celebrate Christmas <b>on</b> December 25th. (Ми святкуємо Різдво 25 грудня.)<br>\n" +
                                    "- She was born <b>on</b> New Year’s Eve. (Вона народилася у новорічну ніч.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник використовується з днями тижня?",
                            options = listOf("in", "on", "at", "for"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Прийменник 'at' – для точного часу</b><br>\n" +
                                    "Використовується для позначення <b>точного часу, частин доби та деяких виразів</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The train arrives <b>at</b> 5 PM. (Поїзд прибуває о 17:00.)<br>\n" +
                                    "- We eat lunch <b>at</b> noon. (Ми обідаємо опівдні.)<br>\n" +
                                    "- She studies <b>at</b> night. (Вона навчається вночі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник використовується з часом?",
                            options = listOf("in", "on", "at", "by"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Порівняння 'in', 'on', 'at'</b><br>\n" +
                                    "- <b>In</b> – для місяців, років, частин доби (in June, in 2022, in the morning).<br>\n" +
                                    "- <b>On</b> – для днів, дат (on Monday, on April 10th, on Christmas Day).<br>\n" +
                                    "- <b>At</b> – для точного часу, моментів дня (at 8 AM, at midnight, at noon).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник слід використати у фразі: '... Monday, I have an exam'?",
                            options = listOf("in", "on", "at", "by"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 27,
                    title = "Розділ 27",
                    topic = "Прийменники напрямку (to, into, out of, from)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Прийменники напрямку</b><br>\n" +
                                    "Прийменники напрямку (prepositions of direction) показують рух у певному напрямку.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Прийменник 'to' – рух до місця</b><br>\n" +
                                    "- Використовується, коли щось рухається <b>в напрямку</b> певного місця.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- We are going <b>to</b> the park. (Ми йдемо в парк.)<br>\n" +
                                    "- She is driving <b>to</b> work. (Вона їде на роботу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник використовується для позначення напрямку до місця?",
                            options = listOf("to", "from", "into", "out of"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Прийменник 'into' – рух всередину</b><br>\n" +
                                    "- Використовується, коли щось рухається <b>усередину</b> приміщення або об'єкта.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He walked <b>into</b> the room. (Він увійшов у кімнату.)<br>\n" +
                                    "- She jumped <b>into</b> the pool. (Вона стрибнула в басейн.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає рух всередину чогось?",
                            options = listOf("to", "into", "from", "on"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Прийменник 'out of' – рух назовні</b><br>\n" +
                                    "- Використовується, коли щось виходить <b>зсередини</b> приміщення або об'єкта.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He went <b>out of</b> the house. (Він вийшов з будинку.)<br>\n" +
                                    "- She got <b>out of</b> the car. (Вона вийшла з машини.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає рух назовні?",
                            options = listOf("into", "to", "from", "out of"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Прийменник 'from' – рух від місця</b><br>\n" +
                                    "- Використовується, коли щось рухається <b>від</b> місця або джерела.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- They came <b>from</b> the USA. (Вони приїхали з США.)<br>\n" +
                                    "- I got a letter <b>from</b> my friend. (Я отримав листа від друга.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає рух від певного місця?",
                            options = listOf("to", "into", "from", "out of"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Порівняння прийменників напрямку:</b><br>\n" +
                                    "- <b>to</b> – рух до місця (I am going <b>to</b> school.)<br>\n" +
                                    "- <b>into</b> – рух усередину (He went <b>into</b> the house.)<br>\n" +
                                    "- <b>out of</b> – рух назовні (She walked <b>out of</b> the room.)<br>\n" +
                                    "- <b>from</b> – рух від місця (They came <b>from</b> Italy.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який прийменник означає рух всередину?",
                            options = listOf("to", "into", "from", "out of"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 28,
                    title = "Розділ 28",
                    topic = "Сполучники (and, but, because, so)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Сполучники в англійській мові</b><br>\n" +
                                    "Сполучники (conjunctions) – це слова, які з'єднують частини речення або окремі речення.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Сполучник 'and' – і, та</b><br>\n" +
                                    "- Використовується для з'єднання схожих ідей або предметів.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I like coffee <b>and</b> tea. (Я люблю каву і чай.)<br>\n" +
                                    "- She is smart <b>and</b> kind. (Вона розумна і добра.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для з'єднання схожих ідей?",
                            options = listOf("but", "because", "and", "so"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Сполучник 'but' – але</b><br>\n" +
                                    "- Використовується для протиставлення двох ідей.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I like coffee, <b>but</b> I don’t like tea. (Мені подобається кава, але не подобається чай.)<br>\n" +
                                    "- He is tall, <b>but</b> not strong. (Він високий, але не сильний.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для протиставлення?",
                            options = listOf("so", "but", "and", "because"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Сполучник 'because' – тому що</b><br>\n" +
                                    "- Використовується для пояснення причини.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I stayed at home <b>because</b> it was raining. (Я залишився вдома, тому що йшов дощ.)<br>\n" +
                                    "- She is happy <b>because</b> she won the game. (Вона щаслива, тому що виграла гру.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для пояснення причини?",
                            options = listOf("and", "but", "because", "so"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Сполучник 'so' – отже, тому</b><br>\n" +
                                    "- Використовується для позначення результату або наслідку.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- It was late, <b>so</b> we went home. (Було пізно, тому ми пішли додому.)<br>\n" +
                                    "- She was tired, <b>so</b> she went to bed early. (Вона була втомлена, тому лягла спати рано.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для позначення результату?",
                            options = listOf("because", "and", "but", "so"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>Підсумок:</b><br>\n" +
                                    "- <b>And</b> – додає інформацію (I like apples <b>and</b> oranges).<br>\n" +
                                    "- <b>But</b> – виражає протилежність (I am tall, <b>but</b> he is short).<br>\n" +
                                    "- <b>Because</b> – пояснює причину (I left <b>because</b> I was tired).<br>\n" +
                                    "- <b>So</b> – показує наслідок (It was hot, <b>so</b> we went swimming).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для додавання інформації?",
                            options = listOf("but", "because", "so", "and"),
                            correctAnswerIndex = 3
                        )
                    )
                ),
                Lesson(
                    id = 29,
                    title = "Розділ 29",
                    topic = "З'єднання простих речень у складні",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>З'єднання простих речень у складні</b><br>\n" +
                                    "У англійській мові можна з'єднувати прості речення у складні за допомогою сполучників.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Сполучники для поєднання подібних ідей:</b><br>\n" +
                                    "- Використовується сполучник <b>and</b> (і, та) для додавання інформації.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I like coffee. I like tea. → I like coffee <b>and</b> tea. (Я люблю каву і чай.)<br>\n" +
                                    "- She studies hard. She gets good grades. → She studies hard <b>and</b> gets good grades. (Вона старанно вчиться і отримує хороші оцінки.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для поєднання подібних ідей?",
                            options = listOf("but", "and", "so", "because"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Сполучники для протиставлення ідей:</b><br>\n" +
                                    "- Використовується <b>but</b> (але) для вираження протилежних ідей.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I like coffee. I don’t like tea. → I like coffee <b>but</b> I don’t like tea. (Я люблю каву, але не люблю чай.)<br>\n" +
                                    "- He is tall. He is not strong. → He is tall <b>but</b> not strong. (Він високий, але не сильний.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для протиставлення?",
                            options = listOf("so", "because", "and", "but"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>3. Сполучники для пояснення причини:</b><br>\n" +
                                    "- Використовується <b>because</b> (тому що) для пояснення причини.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I stayed home. It was raining. → I stayed home <b>because</b> it was raining. (Я залишився вдома, тому що йшов дощ.)<br>\n" +
                                    "- She is happy. She passed the test. → She is happy <b>because</b> she passed the test. (Вона щаслива, тому що склала тест.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для пояснення причини?",
                            options = listOf("so", "and", "but", "because"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Сполучники для вираження наслідку:</b><br>\n" +
                                    "- Використовується <b>so</b> (отже, тому) для позначення результату.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- It was late. We went home. → It was late, <b>so</b> we went home. (Було пізно, тому ми пішли додому.)<br>\n" +
                                    "- She was tired. She went to bed early. → She was tired, <b>so</b> she went to bed early. (Вона була втомлена, тому лягла спати рано.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для позначення результату?",
                            options = listOf("because", "so", "but", "and"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Сполучники для вибору або альтернативи:</b><br>\n" +
                                    "- Використовується <b>or</b> (або) для вибору між варіантами.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- You can have tea. You can have coffee. → You can have tea <b>or</b> coffee. (Ти можеш випити чай або каву.)<br>\n" +
                                    "- We can go now. We can wait. → We can go now <b>or</b> wait. (Ми можемо піти зараз або почекати.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для вибору між варіантами?",
                            options = listOf("so", "or", "but", "because"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Підсумок:</b><br>\n" +
                                    "- <b>And</b> – додає інформацію (I like apples <b>and</b> oranges).<br>\n" +
                                    "- <b>But</b> – виражає протилежність (I am tall, <b>but</b> he is short).<br>\n" +
                                    "- <b>Because</b> – пояснює причину (I left <b>because</b> I was tired).<br>\n" +
                                    "- <b>So</b> – показує наслідок (It was hot, <b>so</b> we went swimming).<br>\n" +
                                    "- <b>Or</b> – показує вибір (Do you want tea <b>or</b> coffee?).<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який сполучник використовується для додавання інформації?",
                            options = listOf("but", "because", "so", "and"),
                            correctAnswerIndex = 3
                        )
                    )
                ),
                Lesson(
                    id = 30,
                    title = "Розділ 30",
                    topic = "Кількісні числівники (one, two, three)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Кількісні числівники</b><br>\n" +
                                    "Кількісні числівники (cardinal numbers) вказують на кількість предметів або осіб.<br>\n" +
                                    "<br>\n" +
                                    "<b>Основні кількісні числівники:</b><br>\n" +
                                    "- 1 – <b>one</b> (один)<br>\n" +
                                    "- 2 – <b>two</b> (два)<br>\n" +
                                    "- 3 – <b>three</b> (три)<br>\n" +
                                    "- 4 – <b>four</b> (чотири)<br>\n" +
                                    "- 5 – <b>five</b> (п'ять)<br>\n" +
                                    "- 6 – <b>six</b> (шість)<br>\n" +
                                    "- 7 – <b>seven</b> (сім)<br>\n" +
                                    "- 8 – <b>eight</b> (вісім)<br>\n" +
                                    "- 9 – <b>nine</b> (дев'ять)<br>\n" +
                                    "- 10 – <b>ten</b> (десять)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово означає число 7?",
                            options = listOf("six", "seven", "eight", "nine"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Числа від 11 до 20:</b><br>\n" +
                                    "- 11 – <b>eleven</b> (одинадцять)<br>\n" +
                                    "- 12 – <b>twelve</b> (дванадцять)<br>\n" +
                                    "- 13 – <b>thirteen</b> (тринадцять)<br>\n" +
                                    "- 14 – <b>fourteen</b> (чотирнадцять)<br>\n" +
                                    "- 15 – <b>fifteen</b> (п’ятнадцять)<br>\n" +
                                    "- 16 – <b>sixteen</b> (шістнадцять)<br>\n" +
                                    "- 17 – <b>seventeen</b> (сімнадцять)<br>\n" +
                                    "- 18 – <b>eighteen</b> (вісімнадцять)<br>\n" +
                                    "- 19 – <b>nineteen</b> (дев’ятнадцять)<br>\n" +
                                    "- 20 – <b>twenty</b> (двадцять)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово означає число 15?",
                            options = listOf("fourteen", "fifteen", "sixteen", "seventeen"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Десятки:</b><br>\n" +
                                    "- 30 – <b>thirty</b> (тридцять)<br>\n" +
                                    "- 40 – <b>forty</b> (сорок)<br>\n" +
                                    "- 50 – <b>fifty</b> (п’ятдесят)<br>\n" +
                                    "- 60 – <b>sixty</b> (шістдесят)<br>\n" +
                                    "- 70 – <b>seventy</b> (сімдесят)<br>\n" +
                                    "- 80 – <b>eighty</b> (вісімдесят)<br>\n" +
                                    "- 90 – <b>ninety</b> (дев’яносто)<br>\n" +
                                    "- 100 – <b>one hundred</b> (сто)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово означає число 40?",
                            options = listOf("fourty", "forty", "fourteen", "four"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Числа від 100 до 1000:</b><br>\n" +
                                    "- 200 – <b>two hundred</b> (двісті)<br>\n" +
                                    "- 300 – <b>three hundred</b> (триста)<br>\n" +
                                    "- 400 – <b>four hundred</b> (чотириста)<br>\n" +
                                    "- 500 – <b>five hundred</b> (п’ятсот)<br>\n" +
                                    "- 600 – <b>six hundred</b> (шістсот)<br>\n" +
                                    "- 700 – <b>seven hundred</b> (сімсот)<br>\n" +
                                    "- 800 – <b>eight hundred</b> (вісімсот)<br>\n" +
                                    "- 900 – <b>nine hundred</b> (дев’ятсот)<br>\n" +
                                    "- 1000 – <b>one thousand</b> (тисяча)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово означає число 1000?",
                            options = listOf("hundred", "ten hundred", "one thousand", "thousand"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>Як утворювати числа:</b><br>\n" +
                                    "- 125 – <b>one hundred twenty-five</b><br>\n" +
                                    "- 342 – <b>three hundred forty-two</b><br>\n" +
                                    "- 678 – <b>six hundred seventy-eight</b><br>\n" +
                                    "- 999 – <b>nine hundred ninety-nine</b><br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке число відповідає 'three hundred fifty-six'?",
                            options = listOf("356", "365", "536", "653"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 31,
                    title = "Розділ 31",
                    topic = "Як казати час і дати",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Як казати час англійською</b><br>\n" +
                                    "В англійській мові час можна виражати у двох форматах: <b>12-годинний</b> (am/pm) та <b>24-годинний</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Повна година:</b><br>\n" +
                                    "- It is <b>five o’clock</b>. (Зараз п'ята година.)<br>\n" +
                                    "- It is <b>ten o’clock</b>. (Зараз десята година.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 7:00 англійською?",
                            options = listOf("It is seven o’clock", "It is seven hour", "It is seven pm", "It is seven time"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Хвилини: половина, чверть</b><br>\n" +
                                    "- 5:30 → It is <b>half past five</b>. (Пів на шосту.)<br>\n" +
                                    "- 6:15 → It is <b>quarter past six</b>. (Шоста п’ятнадцять.)<br>\n" +
                                    "- 7:45 → It is <b>quarter to eight</b>. (Без п’ятнадцяти вісім.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 8:15 англійською?",
                            options = listOf("It is quarter past eight", "It is half past eight", "It is quarter to eight", "It is eight fifteen"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Хвилини у форматі 'past' і 'to'</b><br>\n" +
                                    "- 9:10 → It is <b>ten past nine</b>. (Десять хвилин на десяту.)<br>\n" +
                                    "- 10:50 → It is <b>ten to eleven</b>. (Без десяти одинадцять.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 7:55 англійською?",
                            options = listOf("It is five past seven", "It is five to eight", "It is seven fifty-five", "It is five before eight"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Використання AM та PM</b><br>\n" +
                                    "- AM (Ante Meridiem) – до полудня (0:00-11:59).<br>\n" +
                                    "- PM (Post Meridiem) – після полудня (12:00-23:59).<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- 6:00 AM → It is six o’clock in the morning.<br>\n" +
                                    "- 9:00 PM → It is nine o’clock in the evening.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'PM' у позначенні часу?",
                            options = listOf("До полудня", "Після полудня", "Ранок", "Опівночі"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>Як казати дати англійською</b><br>\n" +
                                    "В англійській мові дати зазвичай говорять з порядковими числівниками.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Дати у британському та американському форматах:</b><br>\n" +
                                    "- Британський: <b>day + month + year</b> (10th February 2024)<br>\n" +
                                    "- Американський: <b>month + day + year</b> (February 10th, 2024)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який формат дат використовується у Великій Британії?",
                            options = listOf("Month-Day-Year", "Day-Month-Year", "Year-Month-Day", "Day-Year-Month"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як казати дати:</b><br>\n" +
                                    "- 1st January → The first of January.<br>\n" +
                                    "- 15th August → The fifteenth of August.<br>\n" +
                                    "- 25th December → The twenty-fifth of December.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно сказати 4 липня англійською?",
                            options = listOf("The fourth of July", "Four July", "July the fourth", "Four of July"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як казати роки:</b><br>\n" +
                                    "- 1999 → Nineteen ninety-nine<br>\n" +
                                    "- 2023 → Twenty twenty-three<br>\n" +
                                    "- 1805 → Eighteen oh five<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 2022 англійською?",
                            options = listOf("Two thousand twenty-two", "Twenty twenty-two", "Two oh two two", "Both 1 and 2 are correct"),
                            correctAnswerIndex = 3
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_grammar_a1 // Додаємо іконку
        ),
        Course(
            id = 2,
            title = "Граматика",
            level = "Англійська рівень А2",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Present Perfect – утворення, використання, маркери часу",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Present Perfect</b><br>\n" +
                                    "Present Perfect використовується для опису дій, які відбулися в минулому, але мають зв’язок із теперішнім часом.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Present Perfect:</b><br>\n" +
                                    "- <b>have/has + дієслово у третій формі (Past Participle)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>have seen</b> this movie. (Я бачив цей фільм.)<br>\n" +
                                    "- She <b>has visited</b> Paris. (Вона відвідала Париж.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Present Perfect?",
                            options = listOf("Subject + have/has + V3", "Subject + had + V3", "Subject + will have + V3", "Subject + was/were + V3"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Present Perfect:</b><br>\n" +
                                    "- Для дій, що сталися у невизначений момент у минулому:<br>\n" +
                                    "  - I <b>have been</b> to Spain. (Я був в Іспанії.)<br>\n" +
                                    "- Для дій, що розпочалися в минулому та тривають до тепер:<br>\n" +
                                    "  - She <b>has lived</b> here for five years. (Вона живе тут п’ять років.)<br>\n" +
                                    "- Для недавніх дій, що мають результат у теперішньому часі:<br>\n" +
                                    "  - They <b>have just finished</b> dinner. (Вони щойно закінчили вечерю.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Present Perfect?",
                            options = listOf("Для дій, що відбуваються зараз", "Для дій, що сталися у конкретний момент", "Для дій, що сталися у невизначений момент у минулому", "Для запланованих дій у майбутньому"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Present Perfect:</b><br>\n" +
                                    "- <b>just</b> (щойно): I <b>have just eaten</b> lunch.<br>\n" +
                                    "- <b>already</b> (вже): She <b>has already finished</b> her work.<br>\n" +
                                    "- <b>yet</b> (ще/вже, у запитаннях і запереченнях): Have you <b>finished</b> your homework yet?<br>\n" +
                                    "- <b>never</b> (ніколи): I <b>have never seen</b> snow.<br>\n" +
                                    "- <b>ever</b> (колись, у запитаннях): Have you <b>ever been</b> to Japan?<br>\n" +
                                    "- <b>for</b> (протягом): They <b>have lived</b> here for three years.<br>\n" +
                                    "- <b>since</b> (з якогось часу): She <b>has worked</b> here since 2010.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу використовується для позначення тривалості?",
                            options = listOf("just", "already", "for", "never"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Present Perfect</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>have not (haven’t) / has not (hasn’t) + V3</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>haven’t seen</b> that movie. (Я не бачив цей фільм.)<br>\n" +
                                    "- She <b>hasn’t finished</b> her homework. (Вона не закінчила домашнє завдання.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечення у Present Perfect?",
                            options = listOf("She haven’t been", "She hasn’t been", "She don’t been", "She isn’t been"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Present Perfect</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>have/has</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Have</b> you ever traveled abroad? (Ти коли-небудь подорожував за кордон?)<br>\n" +
                                    "- <b>Has</b> she finished her project yet? (Вона вже закінчила свій проєкт?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Present Perfect?",
                            options = listOf("She has been?", "Has she been?", "Been she has?", "She been has?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Present Perfect Continuous – утворення, використання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Present Perfect Continuous</b><br>\n" +
                                    "Present Perfect Continuous використовується для вираження дій, які розпочалися в минулому і все ще тривають або щойно закінчилися.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Present Perfect Continuous:</b><br>\n" +
                                    "- <b>have/has + been + дієслово з -ing</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>have been working</b> here for five years. (Я працюю тут п’ять років.)<br>\n" +
                                    "- She <b>has been studying</b> all day. (Вона навчалася весь день.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Present Perfect Continuous?",
                            options = listOf("Subject + have/has + V3", "Subject + have/has + been + V-ing", "Subject + had + V-ing", "Subject + was/were + V-ing"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Present Perfect Continuous:</b><br>\n" +
                                    "- Для дій, що почалися у минулому і все ще тривають:<br>\n" +
                                    "  - He <b>has been living</b> in London since 2015. (Він живе в Лондоні з 2015 року.)<br>\n" +
                                    "- Для дій, які щойно завершилися і мають видимий результат:<br>\n" +
                                    "  - She <b>has been cooking</b> all morning. The kitchen is a mess! (Вона готувала весь ранок. Кухня у безладі!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Present Perfect Continuous?",
                            options = listOf("Для дій, що відбуваються зараз", "Для дій, що закінчилися у конкретний момент", "Для дій, що тривали в минулому і мають зв’язок із теперішнім", "Для майбутніх запланованих дій"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Present Perfect Continuous:</b><br>\n" +
                                    "- <b>for</b> (протягом): I <b>have been waiting</b> for 30 minutes.<br>\n" +
                                    "- <b>since</b> (з певного часу): They <b>have been studying</b> since morning.<br>\n" +
                                    "- <b>lately</b> (останнім часом): She <b>has been feeling</b> tired lately.<br>\n" +
                                    "- <b>recently</b> (недавно): He <b>has been working</b> a lot recently.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу використовується для позначення періоду часу?",
                            options = listOf("since", "already", "just", "for"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Present Perfect Continuous</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>have not (haven’t) / has not (hasn’t) + been + V-ing</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>haven’t been working</b> here for long. (Я не працюю тут довго.)<br>\n" +
                                    "- She <b>hasn’t been feeling</b> well. (Вона погано почувається.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечення у Present Perfect Continuous?",
                            options = listOf("She haven’t been working", "She hasn’t been working", "She don’t been working", "She isn’t been working"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Present Perfect Continuous</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>have/has</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Have</b> you been studying? (Ти навчався?)<br>\n" +
                                    "- <b>Has</b> she been working a lot lately? (Вона багато працювала останнім часом?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Present Perfect Continuous?",
                            options = listOf("She has been working?", "Has she been working?", "Been she has working?", "She been working has?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Past Continuous – утворення, використання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Past Continuous</b><br>\n" +
                                    "Past Continuous використовується для опису дій, що тривали в певний момент у минулому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Past Continuous:</b><br>\n" +
                                    "- <b>was/were + дієслово з -ing</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>was reading</b> a book at 7 PM. (Я читав книгу о 7 вечора.)<br>\n" +
                                    "- They <b>were playing</b> football when it started to rain. (Вони грали у футбол, коли почався дощ.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Past Continuous?",
                            options = listOf("Subject + have/has + V-ing", "Subject + was/were + V-ing", "Subject + had + V-ing", "Subject + did + V-ing"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Past Continuous:</b><br>\n" +
                                    "- Для дій, що відбувалися у певний момент у минулому:<br>\n" +
                                    "  - She <b>was cooking</b> dinner at 6 PM. (Вона готувала вечерю о 6 вечора.)<br>\n" +
                                    "- Для дій, які тривали певний час у минулому:<br>\n" +
                                    "  - We <b>were watching</b> TV all evening. (Ми дивилися телевізор увесь вечір.)<br>\n" +
                                    "- Для фонових подій у розповідях:<br>\n" +
                                    "  - It <b>was raining</b> when I woke up. (Йшов дощ, коли я прокинувся.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Past Continuous?",
                            options = listOf("Для дій, що відбуваються зараз", "Для тривалих дій у минулому", "Для майбутніх запланованих дій", "Для фактів і звичок"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Past Continuous:</b><br>\n" +
                                    "- <b>at that moment</b> (у той момент): I <b>was working</b> at that moment.<br>\n" +
                                    "- <b>while</b> (поки, в той час як): She <b>was reading</b> while he <b>was cooking</b>.<br>\n" +
                                    "- <b>when</b> (коли): They <b>were walking</b> when it started to rain.<br>\n" +
                                    "- <b>all day</b> (увесь день): He <b>was studying</b> all day.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу зазвичай використовується з Past Continuous?",
                            options = listOf("yesterday", "when", "tomorrow", "yet"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Past Continuous</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>was not (wasn’t) / were not (weren’t) + V-ing</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>wasn’t sleeping</b> at that time. (Я не спав у той час.)<br>\n" +
                                    "- They <b>weren’t listening</b> to the teacher. (Вони не слухали вчителя.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечне речення у Past Continuous?",
                            options = listOf("He wasn’t working", "He don’t working", "He hasn’t working", "He isn’t working"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Past Continuous</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>was/were</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Were</b> they studying at 8 PM? (Вони навчалися о 8 вечора?)<br>\n" +
                                    "- <b>Was</b> she sleeping when you called? (Вона спала, коли ти подзвонив?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Past Continuous?",
                            options = listOf("She was studying?", "Was she studying?", "Studying was she?", "She studying was?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Past Perfect – утворення, використання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Past Perfect</b><br>\n" +
                                    "Past Perfect використовується для опису дій, які відбулися перед іншими подіями у минулому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Past Perfect:</b><br>\n" +
                                    "- <b>had + дієслово у третій формі (Past Participle)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>had finished</b> my work before she arrived. (Я закінчив роботу перед тим, як вона приїхала.)<br>\n" +
                                    "- They <b>had left</b> before we arrived. (Вони пішли перед тим, як ми прийшли.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Past Perfect?",
                            options = listOf("Subject + had + V3", "Subject + was/were + V-ing", "Subject + have/has + V3", "Subject + did + V3"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Past Perfect:</b><br>\n" +
                                    "- Для дії, яка відбулася раніше за іншу подію в минулому:<br>\n" +
                                    "  - He <b>had already eaten</b> when we arrived. (Він уже поїв, коли ми прийшли.)<br>\n" +
                                    "- Для вираження причинно-наслідкового зв’язку в минулому:<br>\n" +
                                    "  - She was sad because she <b>had lost</b> her phone. (Вона була засмучена, бо загубила телефон.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Past Perfect?",
                            options = listOf("Для дій, що відбуваються зараз", "Для дій, що сталися перед іншою подією в минулому", "Для майбутніх запланованих дій", "Для загальних фактів і звичок"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Past Perfect:</b><br>\n" +
                                    "- <b>before</b> (перед): She <b>had left</b> before I arrived.<br>\n" +
                                    "- <b>after</b> (після): They went home after they <b>had finished</b> work.<br>\n" +
                                    "- <b>already</b> (вже): He <b>had already seen</b> that movie.<br>\n" +
                                    "- <b>never</b> (ніколи): I <b>had never been</b> to London before.<br>\n" +
                                    "- <b>just</b> (щойно): She <b>had just gone</b> out when I called.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу використовується для позначення послідовності подій?",
                            options = listOf("just", "before", "for", "since"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Past Perfect</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>had not (hadn’t) + V3</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>hadn’t seen</b> him before. (Я не бачив його раніше.)<br>\n" +
                                    "- She <b>hadn’t finished</b> her homework before the class started. (Вона не закінчила домашнє завдання перед початком уроку.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечне речення у Past Perfect?",
                            options = listOf("He hasn’t finished", "He hadn’t finished", "He didn’t finished", "He doesn’t finished"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Past Perfect</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>had</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Had</b> you seen that movie before? (Ти бачив цей фільм раніше?)<br>\n" +
                                    "- <b>Had</b> she finished her work before the deadline? (Вона закінчила роботу до дедлайну?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Past Perfect?",
                            options = listOf("She had finished?", "Had she finished?", "Finished had she?", "She finished had?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Future Continuous – утворення, використання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Future Continuous</b><br>\n" +
                                    "Future Continuous використовується для опису дій, які будуть тривати у певний момент у майбутньому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Future Continuous:</b><br>\n" +
                                    "- <b>will be + дієслово з -ing</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This time tomorrow, I <b>will be traveling</b> to Paris. (Завтра о цій порі я буду подорожувати до Парижа.)<br>\n" +
                                    "- At 8 PM, they <b>will be having</b> dinner. (О 8 вечора вони будуть вечеряти.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Future Continuous?",
                            options = listOf("Subject + have/has + V-ing", "Subject + will + V-ing", "Subject + will be + V-ing", "Subject + was/were + V-ing"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Future Continuous:</b><br>\n" +
                                    "- Для дій, що будуть тривати у певний момент у майбутньому:<br>\n" +
                                    "  - At 10 AM, I <b>will be working</b>. (О 10 ранку я буду працювати.)<br>\n" +
                                    "- Для ввічливих запитань про плани на майбутнє:<br>\n" +
                                    "  - <b>Will you be coming</b> to the party? (Ти прийдеш на вечірку?)<br>\n" +
                                    "- Для опису дій, які відбудуться як частина звичайного розпорядку:<br>\n" +
                                    "  - She <b>will be teaching</b> English at 5 PM. (Вона буде викладати англійську о 5 вечора.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Future Continuous?",
                            options = listOf("Для дій, що тривають зараз", "Для запланованих подій у минулому", "Для тривалих дій у певний момент майбутнього", "Для фактів і звичок"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Future Continuous:</b><br>\n" +
                                    "- <b>this time tomorrow</b> (у цей час завтра): I <b>will be flying</b> to New York this time tomorrow.<br>\n" +
                                    "- <b>at this time next week</b> (у цей час наступного тижня): We <b>will be working</b> at this time next week.<br>\n" +
                                    "- <b>all day tomorrow</b> (увесь день завтра): She <b>will be studying</b> all day tomorrow.<br>\n" +
                                    "- <b>in a few hours</b> (через кілька годин): They <b>will be arriving</b> in a few hours.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу використовується для Future Continuous?",
                            options = listOf("yesterday", "this time tomorrow", "since", "last week"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Future Continuous</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>will not (won’t) be + V-ing</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>won’t be sleeping</b> at midnight. (Я не буду спати опівночі.)<br>\n" +
                                    "- They <b>won’t be watching</b> TV at this time tomorrow. (Вони не будуть дивитися телевізор у цей час завтра.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечне речення у Future Continuous?",
                            options = listOf("He won’t working", "He won’t be working", "He doesn’t be working", "He wasn’t be working"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Future Continuous</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>will</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Will</b> you be studying at 6 PM? (Ти будеш навчатися о 6 вечора?)<br>\n" +
                                    "- <b>Will</b> they be coming to the meeting? (Вони будуть приходити на зустріч?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Future Continuous?",
                            options = listOf("You will be studying?", "Will you be studying?", "Be you will studying?", "You studying will be?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Future Perfect – утворення, використання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Future Perfect</b><br>\n" +
                                    "Future Perfect використовується для опису дій, які завершаться до певного моменту в майбутньому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення Future Perfect:</b><br>\n" +
                                    "- <b>will have + дієслово у третій формі (Past Participle)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- By next year, I <b>will have graduated</b> from university. (До наступного року я закінчу університет.)<br>\n" +
                                    "- By 8 PM, they <b>will have finished</b> their work. (До 8 вечора вони закінчать роботу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Future Perfect?",
                            options = listOf("Subject + will + V3", "Subject + will be + V-ing", "Subject + will have + V3", "Subject + was/were + V3"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Future Perfect:</b><br>\n" +
                                    "- Для дій, що завершаться до певного моменту в майбутньому:<br>\n" +
                                    "  - By this time tomorrow, she <b>will have arrived</b>. (До цього часу завтра вона вже приїде.)<br>\n" +
                                    "- Для прогнозів щодо завершених дій у майбутньому:<br>\n" +
                                    "  - By the end of the month, we <b>will have completed</b> the project. (До кінця місяця ми завершимо проєкт.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Future Perfect?",
                            options = listOf("Для дій, що тривають зараз", "Для запланованих подій у минулому", "Для дій, що завершаться до певного моменту в майбутньому", "Для загальних фактів і звичок"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Маркери часу для Future Perfect:</b><br>\n" +
                                    "- <b>by</b> (до якогось моменту): I <b>will have finished</b> by 6 PM.<br>\n" +
                                    "- <b>by the time</b> (до того часу, як): By the time you arrive, I <b>will have left</b>.<br>\n" +
                                    "- <b>before</b> (перед): She <b>will have cleaned</b> the house before the guests come.<br>\n" +
                                    "- <b>until</b> (до): He <b>won’t have completed</b> his work until Friday.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який маркер часу зазвичай використовується з Future Perfect?",
                            options = listOf("yesterday", "by", "since", "last week"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Заперечення у Future Perfect</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>will not (won’t) have + V3</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>won’t have finished</b> my work by noon. (Я не закінчу свою роботу до обіду.)<br>\n" +
                                    "- They <b>won’t have arrived</b> by the time we leave. (Вони не приїдуть до того, як ми підемо.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечне речення у Future Perfect?",
                            options = listOf("He won’t have finishing", "He won’t have finished", "He doesn’t have finished", "He wasn’t have finished"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Питальні речення у Future Perfect</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>will</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Will</b> you have finished your homework by 9 PM? (Ти закінчиш домашнє завдання до 9 вечора?)<br>\n" +
                                    "- <b>Will</b> they have left before we arrive? (Вони підуть до того, як ми прийдемо?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у Future Perfect?",
                            options = listOf("You will have finished?", "Will you have finished?", "Have you will finished?", "You finished will have?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Використання 'used to'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Використання 'used to'</b><br>\n" +
                                    "Конструкція <b>used to</b> використовується для опису звичок або станів, що мали місце в минулому, але більше не є актуальними.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення речень з 'used to':</b><br>\n" +
                                    "- <b>used to + інфінітив (V1)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>used to play</b> football when I was a child. (Я грав у футбол, коли був дитиною.)<br>\n" +
                                    "- She <b>used to live</b> in London. (Вона раніше жила в Лондоні.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення з 'used to'?",
                            options = listOf("Subject + used + V1", "Subject + used to + V1", "Subject + was used to + V1", "Subject + had used to + V1"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання 'used to':</b><br>\n" +
                                    "- Для опису регулярних дій у минулому:<br>\n" +
                                    "  - He <b>used to go</b> to the gym every day. (Раніше він ходив у спортзал щодня.)<br>\n" +
                                    "- Для опису станів або фактів у минулому, які зараз не є правдивими:<br>\n" +
                                    "  - They <b>used to have</b> a dog. (У них раніше була собака.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується 'used to'?",
                            options = listOf("Для теперішніх звичок", "Для майбутніх планів", "Для дій або станів у минулому, які більше не відбуваються", "Для подій, що відбуваються зараз"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Заперечення з 'used to':</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>did not (didn’t) use to + V1</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>didn’t use to like</b> vegetables. (Раніше мені не подобалися овочі.)<br>\n" +
                                    "- She <b>didn’t use to wear</b> glasses. (Вона раніше не носила окуляри.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити заперечне речення з 'used to'?",
                            options = listOf("He didn’t used to", "He didn’t use to", "He wasn’t used to", "He not used to"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Питальні речення з 'used to':</b><br>\n" +
                                    "- Запитання утворюється за допомогою <b>Did + підмет + use to + V1</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Did</b> you <b>use to play</b> soccer? (Ти грав у футбол раніше?)<br>\n" +
                                    "- <b>Did</b> she <b>use to work</b> here? (Вона раніше тут працювала?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання з 'used to'?",
                            options = listOf("Used he to play?", "Did he used to play?", "Did he use to play?", "Was he used to play?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Різниця між 'used to' та 'be used to':</b><br>\n" +
                                    "- <b>Used to + V1</b> → минулі звички (I used to wake up early.)<br>\n" +
                                    "- <b>Be used to + V-ing</b> → бути звичним до чогось (I am used to waking up early.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка різниця між 'used to' та 'be used to'?",
                            options = listOf("'Used to' для теперішніх звичок", "'Be used to' означає минулі звички", "'Used to' – для минулих звичок, 'be used to' – для теперішніх звичок", "Вони мають однакове значення"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Модальні дієслова в минулому (could, should have, must have)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Модальні дієслова в минулому</b><br>\n" +
                                    "Модальні дієслова <b>could, should have, must have</b> використовуються для вираження можливості, необхідності або припущень у минулому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. 'Could' – минула форма 'can'</b><br>\n" +
                                    "- Використовується для вираження можливості або здатності в минулому.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- When I was a child, I <b>could run</b> very fast. (Коли я був дитиною, я міг швидко бігати.)<br>\n" +
                                    "- She <b>couldn’t find</b> her keys yesterday. (Вона не могла знайти свої ключі вчора.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення з 'could' у минулому?",
                            options = listOf("Subject + could + V1", "Subject + could + V2", "Subject + have + could + V3", "Subject + was/were + could + V1"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. 'Should have' – вираження жалю або рекомендації щодо минулого</b><br>\n" +
                                    "- Використовується для вираження дії, яка повинна була відбутися, але не відбулася.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- You <b>should have studied</b> more. (Тобі слід було вчитися більше.)<br>\n" +
                                    "- He <b>shouldn’t have bought</b> that expensive car. (Йому не варто було купувати ту дорогу машину.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення з 'should have'?",
                            options = listOf("Subject + should have + V3", "Subject + should + have + V1", "Subject + should + V2", "Subject + have + should + V3"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. 'Must have' – припущення щодо минулого</b><br>\n" +
                                    "- Використовується, коли ми впевнені, що щось сталося в минулому.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- She <b>must have forgotten</b> about the meeting. (Вона, напевно, забула про зустріч.)<br>\n" +
                                    "- They <b>must have been</b> very tired after the trip. (Вони, напевно, були дуже втомлені після подорожі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення з 'must have'?",
                            options = listOf("Subject + must have + V3", "Subject + must + V2", "Subject + had to + V3", "Subject + have + must + V3"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Порівняння модальних дієслів у минулому</b><br>\n" +
                                    "- <b>Could</b> – можливість у минулому (I <b>could</b> swim when I was five.)<br>\n" +
                                    "- <b>Should have</b> – дія, яка повинна була відбутися, але не відбулася (You <b>should have called</b> me.)<br>\n" +
                                    "- <b>Must have</b> – впевненість щодо минулого (She <b>must have left</b> already.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке модальне дієслово виражає припущення про минуле?",
                            options = listOf("Could", "Should have", "Must have", "Would have"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Конструкція 'going to' для майбутнього часу",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Конструкція 'going to' для вираження майбутнього часу</b><br>\n" +
                                    "Конструкція <b>be going to</b> використовується для вираження запланованих дій у майбутньому або для прогнозів на основі наявних фактів.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Утворення 'going to':</b><br>\n" +
                                    "- <b>am/is/are + going to + дієслово (V1)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>am going to visit</b> my grandmother tomorrow. (Я збираюся відвідати бабусю завтра.)<br>\n" +
                                    "- They <b>are going to move</b> to a new house next month. (Вони збираються переїхати в новий будинок наступного місяця.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення з 'going to'?",
                            options = listOf("Subject + be + going to + V1", "Subject + will + going to + V1", "Subject + has + going to + V1", "Subject + do + going to + V1"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання 'going to':</b><br>\n" +
                                    "- Для планів і намірів на майбутнє:<br>\n" +
                                    "  - She <b>is going to study</b> medicine. (Вона збирається вивчати медицину.)<br>\n" +
                                    "- Для передбачень, заснованих на наявних доказах:<br>\n" +
                                    "  - Look at those clouds! It <b>is going to rain</b>. (Подивися на ці хмари! Буде дощ.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується 'going to'?",
                            options = listOf("Для запланованих дій у майбутньому", "Для загальних фактів", "Для теперішніх звичок", "Для минулих дій"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Заперечення з 'going to':</b><br>\n" +
                                    "- Заперечні речення утворюються за допомогою <b>am not / isn’t / aren’t + going to + V1</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>am not going to buy</b> a new phone. (Я не збираюся купувати новий телефон.)<br>\n" +
                                    "- He <b>isn’t going to travel</b> this summer. (Він не збирається подорожувати цього літа.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке правильне заперечне речення з 'going to'?",
                            options = listOf("He isn’t going to travel", "He don’t going to travel", "He hasn’t going to travel", "He wasn’t going to travel"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Питальні речення з 'going to':</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення <b>am/is/are</b> перед підметом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Are</b> you <b>going to watch</b> the movie tonight? (Ти збираєшся дивитися цей фільм сьогодні ввечері?)<br>\n" +
                                    "- <b>Is</b> she <b>going to call</b> you? (Вона збирається тобі подзвонити?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання з 'going to'?",
                            options = listOf("Going to she is?", "Is she going to?", "Does she going to?", "She is going to?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. 'Going to' vs 'Will'</b><br>\n" +
                                    "- <b>Going to</b> використовується для запланованих дій або передбачень на основі фактів (I <b>am going to buy</b> a new car.)<br>\n" +
                                    "- <b>Will</b> використовується для спонтанних рішень або передбачень без доказів (I <b>will buy</b> a new car someday.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка різниця між 'going to' і 'will'?",
                            options = listOf("'Going to' використовується для спонтанних рішень", "'Will' використовується для запланованих дій", "'Going to' – для запланованих дій, 'will' – для рішень, прийнятих на місці", "Вони означають те саме"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "Порівняльні конструкції (as...as, more/less than)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Порівняльні конструкції в англійській мові</b><br>\n" +
                                    "У англійській мові існують різні способи порівняння предметів, осіб або дій.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Конструкція 'as...as' – рівність</b><br>\n" +
                                    "- Використовується для порівняння двох речей, що мають однакову характеристику.<br>\n" +
                                    "<b>Формула:</b> <b>as + прикметник/прислівник + as</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This car is <b>as fast as</b> that one. (Ця машина така ж швидка, як та.)<br>\n" +
                                    "- She speaks <b>as clearly as</b> her teacher. (Вона говорить так само чітко, як її вчитель.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція використовується для порівняння рівності?",
                            options = listOf("more...than", "as...as", "less...than", "the most"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Конструкції 'more...than' та 'less...than' – вищий ступінь</b><br>\n" +
                                    "- Використовуються для порівняння двох предметів, коли один має більшу або меншу характеристику.<br>\n" +
                                    "<b>Формули:</b><br>\n" +
                                    "- <b>more + довгий прикметник/прислівник + than</b><br>\n" +
                                    "- <b>less + прикметник/прислівник + than</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This book is <b>more interesting than</b> that one. (Ця книга цікавіша за ту.)<br>\n" +
                                    "- He is <b>less experienced than</b> his boss. (Він менш досвідчений, ніж його керівник.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція використовується для порівняння, коли одна характеристика більша?",
                            options = listOf("as...as", "more...than", "less...than", "the least"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Короткі прикметники в порівнянні</b><br>\n" +
                                    "- Короткі прикметники (1-2 склади) змінюються за допомогою закінчення <b>-er</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This road is <b>narrower than</b> that one. (Ця дорога вужча за ту.)<br>\n" +
                                    "- She is <b>happier than</b> before. (Вона щасливіша, ніж раніше.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як змінюється короткий прикметник у порівнянні?",
                            options = listOf("Додається -er", "Додається more", "Додається less", "Змін не відбувається"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Нерівність із 'not as...as'</b><br>\n" +
                                    "- Конструкція <b>not as...as</b> використовується для вираження, що одна річ меншою мірою має певну характеристику.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This exam was <b>not as difficult as</b> the last one. (Цей іспит був не такий складний, як попередній.)<br>\n" +
                                    "- He is <b>not as tall as</b> his brother. (Він не такий високий, як його брат.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція означає нерівність?",
                            options = listOf("as...as", "more...than", "not as...as", "the least"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Винятки у порівняннях</b><br>\n" +
                                    "- Деякі прикметники мають неправильні форми порівняння.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- good → <b>better</b> (кращий)<br>\n" +
                                    "- bad → <b>worse</b> (гірший)<br>\n" +
                                    "- far → <b>farther/further</b> (далі)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке порівняння правильне?",
                            options = listOf("Gooder", "Better", "More good", "Goodest"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Пасивний стан (Present, Past, Future)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Пасивний стан (Passive Voice)</b><br>\n" +
                                    "Пасивний стан використовується, коли дія важливіша за виконавця або виконавець невідомий.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Пасивний стан у Present Simple</b><br>\n" +
                                    "- <b>am/is/are + V3</b> (Past Participle)<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- English <b>is spoken</b> all over the world. (Англійською говорять у всьому світі.)<br>\n" +
                                    "- The letters <b>are sent</b> every day. (Листи надсилають щодня.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура пасиву у Present Simple?",
                            options = listOf("Subject + is/are + V1", "Subject + am/is/are + V3", "Subject + was/were + V3", "Subject + will be + V3"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Пасивний стан у Past Simple</b><br>\n" +
                                    "- <b>was/were + V3</b> (Past Participle)<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The book <b>was written</b> in 1990. (Книга була написана у 1990 році.)<br>\n" +
                                    "- The windows <b>were cleaned</b> yesterday. (Вікна були помиті вчора.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура пасиву у Past Simple?",
                            options = listOf("Subject + have + V3", "Subject + was/were + V3", "Subject + will be + V3", "Subject + had + V3"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Пасивний стан у Future Simple</b><br>\n" +
                                    "- <b>will be + V3</b> (Past Participle)<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The project <b>will be completed</b> next month. (Проєкт буде завершений наступного місяця.)<br>\n" +
                                    "- A new school <b>will be built</b> here. (Тут буде збудована нова школа.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура пасиву у Future Simple?",
                            options = listOf("Subject + will be + V3", "Subject + is/are + V3", "Subject + was/were + V3", "Subject + will + V1"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Коли використовується пасивний стан?</b><br>\n" +
                                    "- Коли дія важливіша за виконавця:<br>\n" +
                                    "  - A new law <b>was passed</b> last year. (Новий закон був прийнятий минулого року.)<br>\n" +
                                    "- Коли виконавець невідомий:<br>\n" +
                                    "  - My bike <b>was stolen</b> last night. (Мій велосипед був вкрадений минулої ночі.)<br>\n" +
                                    "- Коли хочемо зосередитися на об'єкті дії:<br>\n" +
                                    "  - The road <b>is repaired</b> every year. (Дорога ремонтується щороку.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку найчастіше використовується пасивний стан?",
                            options = listOf("Коли виконавець дії невідомий", "Коли дія відбувається зараз", "Коли щось станеться в майбутньому", "Коли дію виконує конкретна особа"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Заперечення у пасивному стані</b><br>\n" +
                                    "- Заперечення утворюється за допомогою <b>not</b> після допоміжного дієслова.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The documents <b>aren’t signed</b> yet. (Документи ще не підписані.)<br>\n" +
                                    "- The house <b>wasn’t built</b> in time. (Будинок не був збудований вчасно.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити заперечне речення у пасивному стані?",
                            options = listOf("The book wasn’t written", "The book don’t written", "The book didn’t written", "The book hasn’t written"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>6. Питальні речення у пасивному стані</b><br>\n" +
                                    "- Запитання утворюється шляхом переставлення допоміжного дієслова на початок.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Is</b> the letter <b>sent</b> every day? (Чи надсилається лист щодня?)<br>\n" +
                                    "- <b>Was</b> the report <b>written</b> on time? (Чи був звіт написаний вчасно?)<br>\n" +
                                    "- <b>Will</b> the house <b>be built</b> next year? (Чи буде будинок збудований наступного року?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання у пасивному стані?",
                            options = listOf("Is the report written?", "The report is written?", "Does the report is written?", "Did the report written?"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Непряма мова (Reported Speech)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Непряма мова (Reported Speech)</b><br>\n" +
                                    "Непряма мова використовується для передачі чиїхось слів без дослівного цитування.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Як змінюється час дієслів у Reported Speech</b><br>\n" +
                                    "- Якщо речення в прямій мові стоїть у минулому часі, то в непрямій мові воно змінюється на один час назад.<br>\n" +
                                    "<b>Зміни часів:</b><br>\n" +
                                    "- Present Simple → Past Simple<br>\n" +
                                    "  - He said, “I <b>like</b> this book.” → He said that he <b>liked</b> that book.<br>\n" +
                                    "- Present Continuous → Past Continuous<br>\n" +
                                    "  - She said, “I <b>am reading</b> a book.” → She said that she <b>was reading</b> a book.<br>\n" +
                                    "- Past Simple → Past Perfect<br>\n" +
                                    "  - They said, “We <b>went</b> to Paris.” → They said that they <b>had gone</b> to Paris.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як змінюється Present Simple у непрямій мові?",
                            options = listOf("Present Continuous", "Past Simple", "Past Perfect", "Не змінюється"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Зміни займенників у Reported Speech</b><br>\n" +
                                    "- Особові займенники змінюються відповідно до підмета.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He said, “<b>I</b> love my job.” → He said that <b>he</b> loved <b>his</b> job.<br>\n" +
                                    "- She said, “<b>We</b> are happy.” → She said that <b>they</b> were happy.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться займенник 'I' у непрямій мові?",
                            options = listOf("You", "We", "He/She", "They"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Зміни часових маркерів у Reported Speech</b><br>\n" +
                                    "- Some words need to change to reflect the shift in time.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- now → then<br>\n" +
                                    "- today → that day<br>\n" +
                                    "- tomorrow → the next day / the following day<br>\n" +
                                    "- yesterday → the day before<br>\n" +
                                    "- next week → the following week<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться слово 'tomorrow' у непрямій мові?",
                            options = listOf("yesterday", "next day", "then", "the following day"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Reported Questions (непрямі питання)</b><br>\n" +
                                    "- У питальних реченнях порядок слів змінюється на прямий порядок.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He asked, “Where <b>is</b> she?” → He asked where she <b>was</b>.<br>\n" +
                                    "- She asked, “Did you see him?” → She asked if I <b>had seen</b> him.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як змінюється порядок слів у питальних реченнях у Reported Speech?",
                            options = listOf("Прямий порядок (Subject + Verb)", "Зворотний порядок (Verb + Subject)", "Без змін", "Замість дієслова використовується 'did'"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Reported Commands (непрямі накази)</b><br>\n" +
                                    "- Використовується 'told' або 'asked' + 'to-infinitive'.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He said, “Close the door.” → He <b>told</b> me to close the door.<br>\n" +
                                    "- She said, “Don’t touch it.” → She <b>told</b> me not to touch it.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура для Reported Commands?",
                            options = listOf("Told + that + V1", "Told + to + V1", "Told + that + V3", "Told + V-ing"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 13,
                    title = "Розділ 13",
                    topic = "Умовні речення 1-го типу (First Conditional)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Умовні речення 1-го типу (First Conditional)</b><br>\n" +
                                    "Умовні речення першого типу використовуються для опису реальних або ймовірних ситуацій у майбутньому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Структура First Conditional</b><br>\n" +
                                    "- <b>If + Present Simple, will + V1</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If it <b>rains</b>, we <b>will stay</b> at home. (Якщо піде дощ, ми залишимося вдома.)<br>\n" +
                                    "- If she <b>studies</b> hard, she <b>will pass</b> the exam. (Якщо вона буде старанно вчитися, вона складе іспит.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у First Conditional?",
                            options = listOf("If + Present Simple, will + V1", "If + Past Simple, would + V1", "If + Present Perfect, will + V1", "If + Past Perfect, would have + V3"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання First Conditional</b><br>\n" +
                                    "- Використовується для подій, які можуть відбутися в майбутньому:<br>\n" +
                                    "  - If we <b>leave</b> now, we <b>will arrive</b> on time. (Якщо ми вирушимо зараз, ми прибудемо вчасно.)<br>\n" +
                                    "- Використовується для попереджень або умов:<br>\n" +
                                    "  - If you <b>don’t wear</b> a coat, you <b>will get</b> cold. (Якщо ти не одягнеш куртку, ти замерзнеш.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується First Conditional?",
                            options = listOf("Для ситуацій у минулому", "Для гіпотетичних ситуацій у теперішньому", "Для можливих ситуацій у майбутньому", "Для подій, які ніколи не можуть трапитися"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Альтернативні конструкції у First Conditional</b><br>\n" +
                                    "- <b>If + Present Simple, can/may/might + V1</b> → для можливих подій:<br>\n" +
                                    "  - If you <b>ask</b> him, he <b>might help</b> you. (Якщо ти його запитаєш, він може тобі допомогти.)<br>\n" +
                                    "- <b>Unless + Present Simple, will + V1</b> → 'якщо не':<br>\n" +
                                    "  - Unless we <b>hurry</b>, we <b>will miss</b> the bus. (Якщо ми не поспішимо, ми пропустимо автобус.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як перекладається 'Unless'?",
                            options = listOf("Якщо", "Якщо не", "Поки", "Навіть якщо"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. First Conditional vs Zero Conditional</b><br>\n" +
                                    "- <b>Zero Conditional</b>: If + Present Simple, Present Simple (загальні істини)<br>\n" +
                                    "  - If you <b>heat</b> water, it <b>boils</b>. (Якщо нагріти воду, вона закипає.)<br>\n" +
                                    "- <b>First Conditional</b>: If + Present Simple, will + V1 (ймовірні майбутні події)<br>\n" +
                                    "  - If you <b>eat</b> too much, you <b>will feel</b> sick. (Якщо ти з’їси забагато, тобі стане погано.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чим відрізняється First Conditional від Zero Conditional?",
                            options = listOf("First Conditional використовується для наукових фактів", "Zero Conditional описує загальні істини, First Conditional – ймовірні майбутні події", "Zero Conditional використовується лише в минулому", "First Conditional ніколи не використовується з 'will'"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 14,
                    title = "Розділ 14",
                    topic = "Умовні речення 2-го типу (Second Conditional)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Умовні речення 2-го типу (Second Conditional)</b><br>\n" +
                                    "Second Conditional використовується для опису гіпотетичних або нереальних ситуацій у теперішньому чи майбутньому.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Структура Second Conditional</b><br>\n" +
                                    "- <b>If + Past Simple, would + V1</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If I <b>had</b> a million dollars, I <b>would buy</b> a big house. (Якби у мене був мільйон доларів, я б купив великий будинок.)<br>\n" +
                                    "- If she <b>were</b> taller, she <b>would play</b> basketball. (Якби вона була вищою, вона б грала в баскетбол.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Second Conditional?",
                            options = listOf("If + Present Simple, will + V1", "If + Past Simple, would + V1", "If + Past Perfect, would have + V3", "If + Present Perfect, will + V1"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Second Conditional</b><br>\n" +
                                    "- Використовується для уявних або малоймовірних ситуацій у теперішньому або майбутньому:<br>\n" +
                                    "  - If I <b>were</b> you, I <b>would accept</b> the offer. (Якби я був на твоєму місці, я б прийняв пропозицію.)<br>\n" +
                                    "- Використовується для вираження порад:<br>\n" +
                                    "  - If she <b>had</b> more free time, she <b>would travel</b> more. (Якби у неї було більше вільного часу, вона б більше подорожувала.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Second Conditional?",
                            options = listOf("Для можливих майбутніх подій", "Для гіпотетичних або нереальних ситуацій у теперішньому або майбутньому", "Для подій, що точно стануться", "Для наукових фактів"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Особливість використання 'were' замість 'was'</b><br>\n" +
                                    "- У Second Conditional завжди використовується <b>were</b> для всіх осіб (включаючи 'I', 'he', 'she', 'it').<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If I <b>were</b> rich, I <b>would travel</b> the world. (Якби я був багатим, я б подорожував світом.)<br>\n" +
                                    "- If he <b>were</b> here, he <b>would help</b> us. (Якби він був тут, він би допоміг нам.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке слово використовується у Second Conditional для всіх осіб?",
                            options = listOf("Was", "Were", "Is", "Has"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Second Conditional vs First Conditional</b><br>\n" +
                                    "- <b>First Conditional</b> (реальна ймовірність): If + Present Simple, will + V1<br>\n" +
                                    "  - If it <b>rains</b>, we <b>will stay</b> at home. (Якщо піде дощ, ми залишимося вдома.)<br>\n" +
                                    "- <b>Second Conditional</b> (гіпотетична ситуація): If + Past Simple, would + V1<br>\n" +
                                    "  - If it <b>rained</b>, we <b>would stay</b> at home. (Якби пішов дощ, ми б залишилися вдома.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чим відрізняється Second Conditional від First Conditional?",
                            options = listOf("Second Conditional описує реальні майбутні події", "First Conditional використовується для неможливих ситуацій", "Second Conditional використовується для гіпотетичних ситуацій, First Conditional – для реальних", "Вони означають те саме"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 15,
                    title = "Розділ 15",
                    topic = "Умовні речення 3-го типу (Third Conditional)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Умовні речення 3-го типу (Third Conditional)</b><br>\n" +
                                    "Third Conditional використовується для опису гіпотетичних ситуацій у минулому, які вже не можуть змінитися.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Структура Third Conditional</b><br>\n" +
                                    "- <b>If + Past Perfect, would have + V3</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If I <b>had studied</b> harder, I <b>would have passed</b> the exam. (Якби я вчився старанніше, я б склав іспит.)<br>\n" +
                                    "- If she <b>had left</b> earlier, she <b>wouldn’t have been</b> late. (Якби вона вийшла раніше, вона б не запізнилася.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура речення у Third Conditional?",
                            options = listOf("If + Past Simple, would + V1", "If + Past Perfect, would have + V3", "If + Present Simple, will + V1", "If + Past Continuous, would + V3"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання Third Conditional</b><br>\n" +
                                    "- Використовується для опису подій, які могли б статися, але не відбулися:<br>\n" +
                                    "  - If he <b>had driven</b> more carefully, he <b>wouldn’t have crashed</b> his car. (Якби він їхав обережніше, він би не розбив свою машину.)<br>\n" +
                                    "- Використовується для вираження жалю щодо минулих подій:<br>\n" +
                                    "  - If I <b>had taken</b> the job, I <b>would have earned</b> more money. (Якби я взяв ту роботу, я б заробляв більше грошей.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У якому випадку використовується Third Conditional?",
                            options = listOf("Для реальних майбутніх подій", "Для гіпотетичних ситуацій у теперішньому", "Для гіпотетичних ситуацій у минулому, які вже не можуть змінитися", "Для подій, які точно відбудуться"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Відмінність Third Conditional від Second Conditional</b><br>\n" +
                                    "- <b>Second Conditional</b>: If + Past Simple, would + V1 (уявні ситуації у теперішньому або майбутньому)<br>\n" +
                                    "  - If I <b>were</b> rich, I <b>would travel</b> a lot. (Якби я був багатим, я б багато подорожував.)<br>\n" +
                                    "- <b>Third Conditional</b>: If + Past Perfect, would have + V3 (гіпотетичні ситуації у минулому)<br>\n" +
                                    "  - If I <b>had been</b> rich, I <b>would have traveled</b> a lot. (Якби я був багатим, я б багато подорожував у минулому.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чим відрізняється Third Conditional від Second Conditional?",
                            options = listOf("Second Conditional описує минулі події", "Third Conditional використовується для можливих ситуацій у майбутньому", "Second Conditional описує уявні ситуації в теперішньому, Third Conditional – уявні ситуації в минулому", "Вони означають те саме"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Альтернативні модальні дієслова у Third Conditional</b><br>\n" +
                                    "- У головній частині речення можна використовувати <b>could have, might have</b> замість <b>would have</b>, щоб змінити значення:<br>\n" +
                                    "  - If you <b>had trained</b> more, you <b>could have won</b> the race. (Якби ти більше тренувався, ти міг би виграти перегони.)<br>\n" +
                                    "  - If she <b>had studied</b> harder, she <b>might have passed</b> the exam. (Якби вона старанніше вчилася, вона, можливо, склала б іспит.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке значення має 'could have' у Third Conditional?",
                            options = listOf("Обов’язковість дії", "Можливість дії у минулому", "Ймовірне майбутнє", "Дія, яка точно станеться"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 16,
                    title = "Розділ 16",
                    topic = "Змішані умовні речення (Mixed Conditionals)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Змішані умовні речення (Mixed Conditionals)</b><br>\n" +
                                    "Змішані умовні речення використовуються, коли частини умовного речення відносяться до різних часових періодів.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Тип 1: Минуле → Теперішнє (Past Perfect + would + V1)</b><br>\n" +
                                    "- Використовується, коли умова стосувалася минулого, але її наслідки проявляються у теперішньому.<br>\n" +
                                    "<b>Формула:</b> If + Past Perfect, would + V1<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If I <b>had studied</b> harder, I <b>would be</b> a doctor now. (Якби я вчився старанніше, я б зараз був лікарем.)<br>\n" +
                                    "- If she <b>hadn't missed</b> the train, she <b>would be</b> here now. (Якби вона не запізнилася на потяг, вона була б тут зараз.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура змішаного умовного речення для зв’язку минулого і теперішнього?",
                            options = listOf("If + Past Simple, will + V1", "If + Past Perfect, would + V1", "If + Present Simple, would + V1", "If + Past Perfect, would have + V3"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Тип 2: Теперішнє → Минуле (If + Past Simple, would have + V3)</b><br>\n" +
                                    "- Використовується, коли теперішній стан впливає на минуле.<br>\n" +
                                    "<b>Формула:</b> If + Past Simple, would have + V3<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If I <b>were</b> more organized, I <b>would have finished</b> the project on time. (Якби я був більш організованим, я б закінчив проєкт вчасно.)<br>\n" +
                                    "- If she <b>wasn't</b> afraid of heights, she <b>would have gone</b> skydiving. (Якби вона не боялася висоти, вона б стрибнула з парашутом.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура змішаного умовного речення для зв’язку теперішнього і минулого?",
                            options = listOf("If + Past Simple, would + V1", "If + Past Perfect, would have + V3", "If + Past Simple, would have + V3", "If + Present Simple, will + V1"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Чому використовуються змішані умовні речення?</b><br>\n" +
                                    "- Вони допомагають поєднувати різні часові періоди у реченні.<br>\n" +
                                    "- Використовуються для вираження нереальних ситуацій у різних часових контекстах.<br>\n" +
                                    "- Дозволяють описати зв’язок між подіями у минулому, теперішньому та майбутньому.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чому використовуються змішані умовні речення?",
                            options = listOf("Щоб говорити про реальні події у майбутньому", "Щоб поєднувати різні часові періоди у реченні", "Щоб описувати лише майбутні дії", "Вони використовуються для фактів і загальних істин"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Порівняння змішаних умовних речень з іншими типами</b><br>\n" +
                                    "- <b>Second Conditional</b> → If + Past Simple, would + V1 (гіпотетичне теперішнє/майбутнє)<br>\n" +
                                    "  - If I <b>were</b> taller, I <b>would play</b> basketball. (Якби я був вищим, я б грав у баскетбол.)<br>\n" +
                                    "- <b>Third Conditional</b> → If + Past Perfect, would have + V3 (гіпотетичне минуле)<br>\n" +
                                    "  - If I <b>had studied</b> harder, I <b>would have passed</b> the exam. (Якби я старанніше вчився, я б склав іспит.)<br>\n" +
                                    "- <b>Mixed Conditional</b> → Поєднання минулого, теперішнього і майбутнього у різних комбінаціях.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як змішані умовні речення відрізняються від Second та Third Conditional?",
                            options = listOf("Вони використовуються лише для майбутнього", "Вони поєднують минуле і теперішнє у різних часових контекстах", "Вони мають ту саму структуру, що й First Conditional", "Вони означають те саме, що і Third Conditional"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 17,
                    title = "Розділ 17",
                    topic = "Relative Clauses (who, which, that, whose, where)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Relative Clauses (Підрядні означальні речення)</b><br>\n" +
                                    "Relative Clauses використовуються для надання додаткової інформації про іменник у реченні.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Who – для людей</b><br>\n" +
                                    "- Використовується для означення особи.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The woman <b>who</b> lives next door is very friendly. (Жінка, яка живе по сусідству, дуже привітна.)<br>\n" +
                                    "- He is the teacher <b>who</b> helped me a lot. (Він той учитель, який мені дуже допоміг.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке відносне займенник використовується для людей?",
                            options = listOf("Which", "Who", "That", "Where"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Which – для речей і тварин</b><br>\n" +
                                    "- Використовується для означення предметів і тварин.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The book <b>which</b> I borrowed was really interesting. (Книга, яку я позичив, була дуже цікава.)<br>\n" +
                                    "- The dog <b>which</b> lives next door is very noisy. (Собака, який живе по сусідству, дуже галасливий.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке відносне займенник використовується для речей?",
                            options = listOf("Who", "That", "Which", "Where"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. That – універсальне займенник</b><br>\n" +
                                    "- Може використовуватися замість 'who' або 'which' у визначальних підрядних реченнях.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The car <b>that</b> I bought is very fast. (Машина, яку я купив, дуже швидка.)<br>\n" +
                                    "- The person <b>that</b> called you is my friend. (Людина, яка тобі дзвонила, – мій друг.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке відносне займенник можна використовувати як універсальне?",
                            options = listOf("Who", "Which", "That", "Where"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Whose – для приналежності</b><br>\n" +
                                    "- Використовується для позначення володіння.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- She is the girl <b>whose</b> brother is a doctor. (Вона дівчина, чий брат – лікар.)<br>\n" +
                                    "- This is the house <b>whose</b> roof needs repairing. (Це будинок, дах якого потребує ремонту.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке відносне займенник вказує на приналежність?",
                            options = listOf("Who", "Which", "That", "Whose"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>5. Where – для місць</b><br>\n" +
                                    "- Використовується для означення місця.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- This is the city <b>where</b> I was born. (Це місто, де я народився.)<br>\n" +
                                    "- Do you remember the restaurant <b>where</b> we had dinner? (Ти пам’ятаєш ресторан, де ми вечеряли?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке відносне займенник використовується для позначення місця?",
                            options = listOf("Who", "Which", "Where", "Whose"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>6. Визначальні та невизначальні підрядні речення</b><br>\n" +
                                    "- <b>Визначальні речення</b>: надають важливу інформацію, без якої речення втрачає сенс.<br>\n" +
                                    "  - The man <b>who</b> called me is my brother. (Чоловік, який мені дзвонив, – мій брат.)<br>\n" +
                                    "- <b>Невизначальні речення</b>: додають додаткову інформацію та виділяються комами.<br>\n" +
                                    "  - My brother, <b>who</b> lives in Canada, is coming to visit. (Мій брат, який живе в Канаді, приїде в гості.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка головна різниця між визначальними та невизначальними підрядними реченнями?",
                            options = listOf("Визначальні додають додаткову інформацію", "Невизначальні виділяються комами і додають додаткову інформацію", "Невизначальні речення використовуються тільки з 'who'", "Визначальні речення завжди містять 'that'"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 18,
                    title = "Розділ 18",
                    topic = "Інверсія в англійських реченнях",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Інверсія в англійських реченнях</b><br>\n" +
                                    "Інверсія – це зміна стандартного порядку слів у реченні (звичайно підмет стоїть перед присудком), коли присудок або допоміжне дієслово стає перед підметом.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Інверсія у питальних реченнях</b><br>\n" +
                                    "- Найпоширеніший випадок інверсії – це утворення питальних речень.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- She is happy. → <b>Is she</b> happy?<br>\n" +
                                    "- They have arrived. → <b>Have they</b> arrived?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна форма інверсії у питальному реченні?",
                            options = listOf("She happy is?", "Is she happy?", "Happy she is?", "She is happy?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Інверсія після негативних слів (Negative Inversion)</b><br>\n" +
                                    "- Якщо речення починається з негативних прислівників або виразів, необхідно використати інверсію.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- Never <b>have I seen</b> such a beautiful view. (Ніколи я не бачив такого прекрасного краєвиду.)<br>\n" +
                                    "- Not only <b>did she pass</b> the exam, but she also got the highest score. (Не тільки вона склала іспит, але й отримала найвищий бал.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення містить правильну інверсію після негативного слова?",
                            options = listOf("Never I saw such a view.", "Never saw I such a view.", "Never have I seen such a view.", "Never I have seen such a view."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Інверсія після 'so', 'such', 'only after', 'hardly', 'no sooner'</b><br>\n" +
                                    "- Деякі вирази викликають інверсію, коли вони стоять на початку речення.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- So <b>beautiful was</b> the sunset that we stopped to admire it. (Захід сонця був настільки красивий, що ми зупинилися помилуватися.)<br>\n" +
                                    "- Only after the meeting <b>did he understand</b> the problem. (Тільки після зустрічі він зрозумів проблему.)<br>\n" +
                                    "- Hardly <b>had I arrived</b> when the train left. (Я тільки-но прибув, як потяг відправився.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна структура інверсії з 'no sooner'?",
                            options = listOf("No sooner I arrived than the meeting started.", "No sooner did I arrive than the meeting started.", "No sooner I did arrive than the meeting started.", "No sooner arrived I than the meeting started."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Інверсія у конструкціях 'There is / There are' та 'Here comes / Here goes'</b><br>\n" +
                                    "- Інверсія також відбувається у виразах з 'there' та 'here'.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- There <b>is</b> a book on the table. (На столі є книга.)<br>\n" +
                                    "- Here <b>comes</b> the bus! (Ось іде автобус!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна інверсія у реченні з 'here'?",
                            options = listOf("Here the bus comes!", "Here comes the bus!", "Here is coming the bus!", "Here the bus is coming!"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Інверсія у реченнях з умовними конструкціями</b><br>\n" +
                                    "- Умовні речення можуть мати інверсію замість 'if'.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- If you should need help → <b>Should you need</b> help. (Якщо тобі знадобиться допомога.)<br>\n" +
                                    "- If I had known → <b>Had I known</b>. (Якби я знав.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка правильна інверсія у реченні з умовною конструкцією?",
                            options = listOf("Had I know", "Had I knew", "Had I known", "Had I knows"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 19,
                    title = "Розділ 19",
                    topic = "Participle Clauses (форми дієприкметників)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Participle Clauses (Дієприкметникові звороти)</b><br>\n" +
                                    "Participle Clauses використовуються для скорочення речень та надання їм більшої гнучкості.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Present Participle Clauses (-ing форма)</b><br>\n" +
                                    "- Використовується для дій, що відбуваються одночасно або як причина іншої дії.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Seeing</b> the police, he ran away. (Побачивши поліцію, він утік.)<br>\n" +
                                    "- She sat on the bench, <b>reading</b> a book. (Вона сиділа на лавці, читаючи книгу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке значення має Present Participle Clause?",
                            options = listOf("Майбутня дія", "Одночасна або причина іншої дії", "Дія у минулому", "Наказ"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Past Participle Clauses (V3 форма)</b><br>\n" +
                                    "- Використовується для пасивних конструкцій або скорочення речень.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Shocked</b> by the news, she couldn’t speak. (Вражена новинами, вона не могла говорити.)<br>\n" +
                                    "- <b>Left</b> unattended, the baby started crying. (Залишений без нагляду, малюк почав плакати.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "У яких випадках використовується Past Participle Clause?",
                            options = listOf("Для активних дій", "Для майбутніх подій", "Для пасивних дій або скорочення речень", "Для запитань"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Perfect Participle Clauses (Having + V3)</b><br>\n" +
                                    "- Використовується для вираження дії, що сталася перед іншою дією.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Having finished</b> his work, he went home. (Закінчивши роботу, він пішов додому.)<br>\n" +
                                    "- <b>Having seen</b> the movie before, I didn’t want to watch it again. (Оскільки я вже бачив цей фільм, я не хотів дивитися його знову.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке значення має Perfect Participle Clause?",
                            options = listOf("Одночасна дія", "Дія, що сталася перед іншою", "Майбутня дія", "Дія у теперішньому"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Participle Clauses vs. Relative Clauses</b><br>\n" +
                                    "- Participle Clauses можуть скорочувати підрядні означальні речення.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The man <b>who is standing</b> there is my friend. → The man <b>standing</b> there is my friend. (Чоловік, який стоїть там, – мій друг.)<br>\n" +
                                    "- The car <b>which was parked</b> outside was stolen. → The car <b>parked</b> outside was stolen. (Машину, припарковану зовні, вкрали.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як Participle Clause може замінити Relative Clause?",
                            options = listOf("Залишається без змін", "Додає нове дієслово", "Скорочує підрядне речення", "Змінює порядок слів"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 20,
                    title = "Розділ 20",
                    topic = "Герундій vs. Інфінітив (Verb + -ing vs. to + Verb)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Герундій (-ing) vs. Інфінітив (to + verb)</b><br>\n" +
                                    "Деякі дієслова та вирази можуть вживатися з герундієм (-ing) або інфінітивом (to + verb), що змінює або зберігає значення.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Дієслова, після яких вживається тільки герундій (-ing)</b><br>\n" +
                                    "- Після деяких дієслів використовується тільки -ing форма.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I enjoy <b>reading</b> books. (Мені подобається читати книги.)<br>\n" +
                                    "- She finished <b>writing</b> the report. (Вона закінчила писати звіт.)<br>\n" +
                                    "<b>Основні дієслова:</b> enjoy, finish, avoid, consider, delay, mind, suggest, practice.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке дієслово потребує герундія (-ing)?",
                            options = listOf("Decide", "Suggest", "Hope", "Want"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Дієслова, після яких вживається тільки інфінітив (to + verb)</b><br>\n" +
                                    "- Після деяких дієслів використовується тільки інфінітив.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He decided <b>to leave</b> early. (Він вирішив піти раніше.)<br>\n" +
                                    "- They want <b>to travel</b> around the world. (Вони хочуть подорожувати світом.)<br>\n" +
                                    "<b>Основні дієслова:</b> decide, hope, want, agree, plan, refuse, learn, manage, offer, promise.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке дієслово потребує інфінітива (to + verb)?",
                            options = listOf("Avoid", "Enjoy", "Decide", "Suggest"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Дієслова, після яких можна використовувати і герундій, і інфінітив</b><br>\n" +
                                    "- Деякі дієслова можуть вживатися як з герундієм, так і з інфінітивом, але зі зміною значення.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Remember + ing</b>: пам'ятати, що щось вже зробили<br>\n" +
                                    "  - I remember <b>locking</b> the door. (Я пам’ятаю, що закрив двері.)<br>\n" +
                                    "- <b>Remember + to</b>: пам'ятати зробити щось<br>\n" +
                                    "  - Remember <b>to lock</b> the door. (Не забудь закрити двері.)<br>\n" +
                                    "- <b>Stop + ing</b>: припинити щось робити<br>\n" +
                                    "  - He stopped <b>smoking</b>. (Він кинув палити.)<br>\n" +
                                    "- <b>Stop + to</b>: зупинитися, щоб щось зробити<br>\n" +
                                    "  - He stopped <b>to smoke</b>. (Він зупинився, щоб закурити.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'stop + ing'?",
                            options = listOf("Припинити щось робити", "Зупинитися, щоб щось зробити", "Пам'ятати зробити щось", "Запланувати щось зробити"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Герундій після прийменників</b><br>\n" +
                                    "- Після всіх прийменників використовується герундій.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He is good at <b>playing</b> chess. (Він добре грає в шахи.)<br>\n" +
                                    "- She is interested in <b>learning</b> Spanish. (Вона цікавиться вивченням іспанської мови.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція правильна після прийменника?",
                            options = listOf("He is good at to play chess.", "He is good at play chess.", "He is good at playing chess.", "He is good at play."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Інфінітив після прикметників</b><br>\n" +
                                    "- Після прикметників зазвичай використовується інфінітив.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- It’s easy <b>to learn</b> English. (Легко вивчити англійську.)<br>\n" +
                                    "- She is happy <b>to see</b> you. (Вона рада тебе бачити.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція правильна після прикметника?",
                            options = listOf("It’s easy learning English.", "It’s easy to learn English.", "It’s easy learn English.", "It’s easy learned English."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 21,
                    title = "Розділ 21",
                    topic = "Фразові дієслова (основні приклади)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Фразові дієслова (Phrasal Verbs)</b><br>\n" +
                                    "Фразові дієслова складаються з основного дієслова та прийменника або прислівника, які змінюють значення дієслова.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Фразові дієслова, що означають початок або завершення дії</b><br>\n" +
                                    "- <b>Wake up</b> – прокидатися<br>\n" +
                                    "  - I <b>woke up</b> at 7 AM. (Я прокинувся о 7 ранку.)<br>\n" +
                                    "- <b>Give up</b> – здаватися, припиняти щось робити<br>\n" +
                                    "  - He <b>gave up</b> smoking last year. (Він кинув палити минулого року.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'give up'?",
                            options = listOf("Продовжувати щось робити", "Припиняти або здаватися", "Прокидатися", "Закінчувати роботу"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Фразові дієслова, пов’язані з рухом</b><br>\n" +
                                    "- <b>Go out</b> – виходити з дому<br>\n" +
                                    "  - We <b>went out</b> for dinner. (Ми вийшли повечеряти.)<br>\n" +
                                    "- <b>Come back</b> – повертатися<br>\n" +
                                    "  - She <b>came back</b> home late. (Вона повернулася додому пізно.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'come back'?",
                            options = listOf("Йти вперед", "Повертатися", "Залишатися вдома", "Зупинятися"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Фразові дієслова, пов’язані з комунікацією</b><br>\n" +
                                    "- <b>Call off</b> – скасувати щось<br>\n" +
                                    "  - They <b>called off</b> the meeting. (Вони скасували зустріч.)<br>\n" +
                                    "- <b>Find out</b> – дізнатися<br>\n" +
                                    "  - I <b>found out</b> the truth. (Я дізнався правду.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'find out'?",
                            options = listOf("Забути щось", "Дізнатися", "Запросити когось", "Відкласти подію"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Фразові дієслова, пов’язані з роботою і навчанням</b><br>\n" +
                                    "- <b>Carry on</b> – продовжувати<br>\n" +
                                    "  - She <b>carried on</b> studying despite the noise. (Вона продовжила навчання, незважаючи на шум.)<br>\n" +
                                    "- <b>Set up</b> – заснувати (бізнес, компанію)<br>\n" +
                                    "  - They <b>set up</b> a new company. (Вони заснували нову компанію.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'set up'?",
                            options = listOf("Завершити роботу", "Відкрити або заснувати щось", "Припинити працювати", "Забути щось"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Фразові дієслова, що означають зміну стану</b><br>\n" +
                                    "- <b>Turn into</b> – перетворитися на щось<br>\n" +
                                    "  - The frog <b>turned into</b> a prince. (Жаба перетворилася на принца.)<br>\n" +
                                    "- <b>Calm down</b> – заспокоїтися<br>\n" +
                                    "  - Please <b>calm down</b>. (Будь ласка, заспокойся.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'calm down'?",
                            options = listOf("Засмутитися", "Заспокоїтися", "Розсердитися", "Підбадьоритися"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 22,
                    title = "Розділ 22",
                    topic = "Складні сполучники (although, despite, in spite of)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Складні сполучники: although, despite, in spite of</b><br>\n" +
                                    "Ці сполучники використовуються для вираження контрасту між двома ідеями.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Although – хоча</b><br>\n" +
                                    "- Вживається перед підметом та присудком.<br>\n" +
                                    "<b>Формула:</b> Although + підмет + присудок<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Although</b> it was raining, they went for a walk. (Хоча йшов дощ, вони пішли на прогулянку.)<br>\n" +
                                    "- <b>Although</b> she was tired, she continued working. (Хоча вона була втомлена, вона продовжила працювати.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно використовувати 'although'?",
                            options = listOf("Перед іменником", "Перед підметом і присудком", "Перед герундієм (-ing)", "Перед прийменником"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Despite – незважаючи на</b><br>\n" +
                                    "- Вживається перед іменником, займенником або герундієм (-ing).<br>\n" +
                                    "<b>Формула:</b> Despite + іменник/герундій<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Despite</b> the rain, they went for a walk. (Незважаючи на дощ, вони пішли на прогулянку.)<br>\n" +
                                    "- <b>Despite</b> being tired, she continued working. (Незважаючи на втому, вона продовжила працювати.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно використовувати 'despite'?",
                            options = listOf("Перед іменником або -ing формою", "Перед підметом і присудком", "Перед модальним дієсловом", "Перед заперечними словами"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. In spite of – незважаючи на</b><br>\n" +
                                    "- Має таке ж значення, як і 'despite', і вживається в тих самих конструкціях.<br>\n" +
                                    "<b>Формула:</b> In spite of + іменник/герундій<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>In spite of</b> the rain, they went for a walk. (Незважаючи на дощ, вони пішли на прогулянку.)<br>\n" +
                                    "- <b>In spite of</b> working hard, he failed the exam. (Незважаючи на наполегливу працю, він провалив іспит.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чи є різниця між 'despite' та 'in spite of'?",
                            options = listOf("Так, 'despite' використовується лише в офіційній мові", "Ні, вони мають однакове значення і використання", "Так, 'in spite of' завжди стоїть на початку речення", "Так, 'despite' використовується лише у розмовній мові"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Відмінності між although, despite та in spite of</b><br>\n" +
                                    "- <b>Although</b> – вживається з підметом та присудком.<br>\n" +
                                    "  - Although it was late, he stayed. (Хоча було пізно, він залишився.)<br>\n" +
                                    "- <b>Despite / In spite of</b> – вживаються з іменником або -ing формою.<br>\n" +
                                    "  - Despite the time, he stayed. (Незважаючи на час, він залишився.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке з цих речень правильне?",
                            options = listOf("Despite it was late, he stayed.", "Although being late, he stayed.", "Although it was late, he stayed.", "In spite of it was late, he stayed."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 23,
                    title = "Розділ 23",
                    topic = "Сполучники часу (before, after, as soon as, while, until)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Сполучники часу (Time Conjunctions)</b><br>\n" +
                                    "Сполучники часу використовуються для зв’язку двох подій у часі.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Before – перед тим як</b><br>\n" +
                                    "- Використовується для позначення дії, яка відбулася раніше за іншу.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Before</b> I went to bed, I brushed my teeth. (Перед тим як лягти спати, я почистив зуби.)<br>\n" +
                                    "- He always calls his mom <b>before</b> he leaves for work. (Він завжди телефонує мамі перед тим, як іти на роботу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'before'?",
                            options = listOf("I eat before I will sleep.", "Before I sleep, I ate.", "Before I slept, I brushed my teeth.", "Before I sleeping, I brushed my teeth."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. After – після того як</b><br>\n" +
                                    "- Використовується для позначення дії, яка відбулася після іншої дії.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>After</b> she finished her homework, she watched TV. (Після того як вона закінчила домашнє завдання, вона подивилася телевізор.)<br>\n" +
                                    "- We will go for a walk <b>after</b> we have lunch. (Ми підемо на прогулянку після того, як пообідаємо.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'after'?",
                            options = listOf("After I will finish, we go.", "After she finishes, she went.", "After I finished my work, I relaxed.", "After I finish, I went."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. As soon as – як тільки</b><br>\n" +
                                    "- Використовується для позначення дії, що відбудеться негайно після іншої.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>As soon as</b> I get home, I will call you. (Як тільки я прийду додому, я тобі подзвоню.)<br>\n" +
                                    "- She left <b>as soon as</b> she finished her work. (Вона пішла, як тільки закінчила свою роботу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке значення має 'as soon as'?",
                            options = listOf("Перед тим як", "Одразу після", "У той самий момент", "Протягом усього часу"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. While – поки, в той час як</b><br>\n" +
                                    "- Використовується для позначення двох дій, які відбуваються одночасно.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>While</b> I was cooking, she was setting the table. (Поки я готував, вона накривала на стіл.)<br>\n" +
                                    "- He listened to music <b>while</b> doing his homework. (Він слухав музику, поки робив домашнє завдання.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'while'?",
                            options = listOf("While I was reading, she cooked.", "While I read, she cooking.", "While I was reading, she was cooking.", "While I reading, she was cooking."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Until – до тих пір поки</b><br>\n" +
                                    "- Використовується для позначення кінцевої точки дії.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- We waited <b>until</b> she arrived. (Ми чекали, поки вона приїхала.)<br>\n" +
                                    "- He stayed up <b>until</b> midnight. (Він не лягав спати до опівночі.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'until'?",
                            options = listOf("Як тільки", "Протягом усього часу", "До певного моменту", "Одразу після"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 24,
                    title = "Розділ 24",
                    topic = "Узгодження часів у реченнях (Sequence of Tenses)",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Узгодження часів у реченнях (Sequence of Tenses)</b><br>\n" +
                                    "Узгодження часів означає, що якщо головне речення стоїть у минулому часі, підрядне також має змінити свій час відповідно.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основне правило узгодження часів</b><br>\n" +
                                    "- Якщо головне речення стоїть у минулому, час у підрядному змінюється на відповідний минулий час.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He said, “I <b>am tired</b>.” → He said that he <b>was tired</b>.<br>\n" +
                                    "- She told me, “I <b>have seen</b> this movie.” → She told me that she <b>had seen</b> that movie.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться 'I am happy' при узгодженні часів?",
                            options = listOf("He said that he was happy.", "He said that he is happy.", "He said that he has been happy.", "He said that he had been happy."),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>2. Зміни часів у підрядному реченні</b><br>\n" +
                                    "- Present Simple → Past Simple<br>\n" +
                                    "  - She said, “I <b>like</b> coffee.” → She said that she <b>liked</b> coffee.<br>\n" +
                                    "- Present Continuous → Past Continuous<br>\n" +
                                    "  - He said, “I <b>am working</b>.” → He said that he <b>was working</b>.<br>\n" +
                                    "- Present Perfect → Past Perfect<br>\n" +
                                    "  - They said, “We <b>have finished</b> the project.” → They said that they <b>had finished</b> the project.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться 'She is studying' при узгодженні часів?",
                            options = listOf("She said that she studies.", "She said that she was studying.", "She said that she is studying.", "She said that she had studied."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Узгодження часів у минулому</b><br>\n" +
                                    "- Past Simple → Past Perfect<br>\n" +
                                    "  - He said, “I <b>visited</b> London.” → He said that he <b>had visited</b> London.<br>\n" +
                                    "- Past Continuous → Past Perfect Continuous<br>\n" +
                                    "  - She said, “I <b>was reading</b> a book.” → She said that she <b>had been reading</b> a book.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться 'They went to Paris' при узгодженні часів?",
                            options = listOf("They said that they went to Paris.", "They said that they had gone to Paris.", "They said that they have gone to Paris.", "They said that they were going to Paris."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Узгодження майбутнього часу</b><br>\n" +
                                    "- 'Will' змінюється на 'would'.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- He said, “I <b>will call</b> you tomorrow.” → He said that he <b>would call</b> me the next day.<br>\n" +
                                    "- She told me, “We <b>will go</b> to the cinema.” → She told me that they <b>would go</b> to the cinema.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як зміниться 'I will help you' при узгодженні часів?",
                            options = listOf("He said that he helps me.", "He said that he has helped me.", "He said that he would help me.", "He said that he had helped me."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Випадки, коли узгодження часів не застосовується</b><br>\n" +
                                    "- Якщо висловлюється загальна істина або факт:<br>\n" +
                                    "  - She said, “The sun <b>rises</b> in the east.” → She said that the sun <b>rises</b> in the east. (Час не змінюється, бо це загальна істина.)<br>\n" +
                                    "- Якщо головне речення в теперішньому часі:<br>\n" +
                                    "  - He says, “I <b>am happy</b>.” → He says that he <b>is happy</b>.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення НЕ вимагає узгодження часів?",
                            options = listOf("She said that she was tired.", "He said that he had gone to the store.", "She said that water boils at 100°C.", "They said that they would come later."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 25,
                    title = "Розділ 25",
                    topic = "Відмінності між 'some', 'any', 'no', 'none'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Відмінності між 'some', 'any', 'no', 'none'</b><br>\n" +
                                    "Ці слова використовуються для вираження кількості або відсутності предметів чи осіб.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Some – трохи, деяка кількість</b><br>\n" +
                                    "- Використовується в стверджувальних реченнях.<br>\n" +
                                    "- Вживається з злічуваними та незлічуваними іменниками.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I have <b>some</b> apples. (У мене є трохи яблук.)<br>\n" +
                                    "- She bought <b>some</b> milk. (Вона купила трохи молока.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'some'?",
                            options = listOf("I don’t have some apples.", "Do you have some water?", "I have some sugar.", "I didn’t buy some milk."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Any – будь-який, який-небудь</b><br>\n" +
                                    "- Використовується в заперечних і питальних реченнях.<br>\n" +
                                    "- Вживається з злічуваними та незлічуваними іменниками.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- Do you have <b>any</b> questions? (У вас є які-небудь питання?)<br>\n" +
                                    "- I don’t have <b>any</b> money. (У мене немає грошей.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'any'?",
                            options = listOf("I have any books.", "She didn’t buy any milk.", "He has any problem.", "I need any help."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. No – немає, відсутність</b><br>\n" +
                                    "- Використовується для заперечення без використання 'not'.<br>\n" +
                                    "- Вживається з злічуваними та незлічуваними іменниками.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I have <b>no</b> time. (У мене немає часу.)<br>\n" +
                                    "- There are <b>no</b> cars on the street. (На вулиці немає машин.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'no'?",
                            options = listOf("I don’t have no friends.", "There are no books on the table.", "She hasn’t no money.", "We don’t no sugar."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. None – жоден, ні один</b><br>\n" +
                                    "- Використовується як займенник, що означає повну відсутність.<br>\n" +
                                    "- Не вживається безпосередньо перед іменником.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I have three pens, but <b>none</b> of them work. (У мене є три ручки, але жодна не працює.)<br>\n" +
                                    "- None of my friends like this movie. (Жоден з моїх друзів не любить цей фільм.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'none'?",
                            options = listOf("I have none books.", "None of my family was there.", "She bought none milk.", "We don’t none of them."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Порівняння 'some', 'any', 'no', 'none'</b><br>\n" +
                                    "- <b>Some</b> – у стверджувальних реченнях (I have some money.)<br>\n" +
                                    "- <b>Any</b> – у питальних і заперечних реченнях (Do you have any money? I don’t have any money.)<br>\n" +
                                    "- <b>No</b> – заперечення без 'not' (I have no money.)<br>\n" +
                                    "- <b>None</b> – займенник, який означає відсутність (None of them were present.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне?",
                            options = listOf("I don’t have no money.", "I have some questions.", "Do you have no friends?", "None books are on the table."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 26,
                    title = "Розділ 26",
                    topic = "Використання 'so' і 'such'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Використання 'so' і 'such'</b><br>\n" +
                                    "So і such використовуються для підсилення значення прикметників та іменників, але їх застосування різниться.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Використання 'so' – настільки, такий</b><br>\n" +
                                    "- 'So' використовується перед прикметниками та прислівниками без іменника.<br>\n" +
                                    "<b>Формула:</b> so + adjective/adverb<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- She is <b>so</b> beautiful. (Вона така красива.)<br>\n" +
                                    "- He ran <b>so</b> fast. (Він біг так швидко.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'so'?",
                            options = listOf("She is such beautiful.", "She is so beautiful.", "She is such a beautiful.", "She is so a beautiful girl."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання 'such' – такий, така, таке, такі</b><br>\n" +
                                    "- 'Such' використовується перед іменниками або перед іменниками з прикметниками.<br>\n" +
                                    "<b>Формула:</b> such + (a/an) + adjective + noun<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- It was <b>such</b> a great movie! (Це був такий чудовий фільм!)<br>\n" +
                                    "- They are <b>such</b> nice people. (Вони такі приємні люди.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'such'?",
                            options = listOf("She is such beautiful.", "It was such a wonderful day.", "He is such fast.", "I had such interesting."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Відмінності між 'so' і 'such'</b><br>\n" +
                                    "- <b>So</b> використовується перед прикметниками або прислівниками без іменника.<br>\n" +
                                    "  - She is <b>so</b> kind. (Вона така добра.)<br>\n" +
                                    "- <b>Such</b> використовується перед іменниками з прикметниками.<br>\n" +
                                    "  - She is <b>such</b> a kind person. (Вона така добра людина.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне?",
                            options = listOf("She is such nice.", "He is so a good friend.", "She is such a nice person.", "It is so an interesting book."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. 'So' і 'Such' у підсилювальних конструкціях</b><br>\n" +
                                    "- 'So' та 'such' часто використовуються у виразах для підсилення.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- The food was <b>so</b> good that we ate everything. (Їжа була такою смачною, що ми все з’їли.)<br>\n" +
                                    "- It was <b>such</b> a hot day that we went swimming. (Це був такий спекотний день, що ми пішли купатися.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка конструкція правильна?",
                            options = listOf("The movie was such good that I watched it twice.", "She was so tired that she went to bed early.", "They had such fun time that they stayed longer.", "He is so an intelligent boy."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 27,
                    title = "Розділ 27",
                    topic = "Структури 'I wish' та 'If only'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Структури 'I wish' та 'If only'</b><br>\n" +
                                    "Ці вирази використовуються для вираження жалю або бажання змінити ситуацію.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. 'I wish' та 'If only' для нереальних ситуацій у теперішньому</b><br>\n" +
                                    "- Використовуються для вираження жалю про те, що відбувається зараз.<br>\n" +
                                    "- Дієслово після 'I wish' або 'If only' стоїть у <b>Past Simple</b>, хоча мова йде про теперішнє.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I wish I <b>were</b> taller. (Хотів би я бути вищим.)<br>\n" +
                                    "- If only she <b>had</b> more time! (Якби ж у неї було більше часу!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно виразити жаль про теперішню ситуацію?",
                            options = listOf("I wish I am taller.", "I wish I were taller.", "I wish I will be taller.", "I wish I have been taller."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. 'I wish' та 'If only' для минулих подій</b><br>\n" +
                                    "- Використовуються для вираження жалю про події, які вже відбулися.<br>\n" +
                                    "- Дієслово після 'I wish' або 'If only' стоїть у <b>Past Perfect</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I wish I <b>had studied</b> harder for the exam. (Хотів би я вчитися старанніше до іспиту.)<br>\n" +
                                    "- If only we <b>had left</b> earlier! (Якби ж ми виїхали раніше!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно виразити жаль про минулу подію?",
                            options = listOf("I wish I study harder.", "I wish I had studied harder.", "I wish I was study harder.", "I wish I study harder yesterday."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. 'I wish' та 'If only' для майбутнього</b><br>\n" +
                                    "- Використовуються для вираження бажання, щоб ситуація змінилася в майбутньому.<br>\n" +
                                    "- Дієслово після 'I wish' або 'If only' стоїть у <b>would + V1</b>.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I wish you <b>would stop</b> shouting. (Хотів би я, щоб ти перестав кричати.)<br>\n" +
                                    "- If only it <b>would stop</b> raining! (Якби ж нарешті припинився дощ!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка структура правильна для вираження бажаної зміни в майбутньому?",
                            options = listOf("I wish she will come.", "I wish she comes.", "I wish she would come.", "I wish she coming."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Відмінності між 'I wish' та 'If only'</b><br>\n" +
                                    "- 'If only' вживається для емоційно сильнішого вираження жалю або бажання.<br>\n" +
                                    "- 'I wish' – більш нейтральне і формальне.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I wish I had more free time. (Хотів би я мати більше вільного часу.)<br>\n" +
                                    "- If only I had more free time! (Якби ж у мене було більше вільного часу!)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Чим 'If only' відрізняється від 'I wish'?",
                            options = listOf("'If only' сильніше виражає емоції", "'If only' використовується тільки в майбутньому", "'I wish' завжди означає минуле", "'I wish' використовується лише в питаннях"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 28,
                    title = "Розділ 28",
                    topic = "Складні прийменникові конструкції",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Складні прийменникові конструкції (Complex Prepositional Phrases)</b><br>\n" +
                                    "Складні прийменникові конструкції складаються з двох або більше слів і використовуються для точнішого вираження зв’язків між частинами речення.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Прийменникові конструкції для вираження місця</b><br>\n" +
                                    "- <b>In front of</b> – перед чимось<br>\n" +
                                    "  - The car is <b>in front of</b> the house. (Машина стоїть перед будинком.)<br>\n" +
                                    "- <b>Next to</b> – поруч із<br>\n" +
                                    "  - The bank is <b>next to</b> the post office. (Банк знаходиться поруч з поштою.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'next to'?",
                            options = listOf("За чимось", "Поруч з чимось", "Навпроти чогось", "Усередині чогось"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Прийменникові конструкції для вираження часу</b><br>\n" +
                                    "- <b>By the time</b> – до того часу як<br>\n" +
                                    "  - <b>By the time</b> we arrived, the movie had already started. (До того часу, як ми прийшли, фільм уже почався.)<br>\n" +
                                    "- <b>In the meantime</b> – тим часом<br>\n" +
                                    "  - She went shopping. <b>In the meantime</b>, I prepared dinner. (Вона пішла за покупками, а тим часом я приготував вечерю.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'by the time'?",
                            options = listOf("Одразу після", "Протягом усього часу", "До того часу як", "Ще до цього"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Прийменникові конструкції для вираження причини</b><br>\n" +
                                    "- <b>Due to</b> – через, завдяки<br>\n" +
                                    "  - The match was canceled <b>due to</b> bad weather. (Матч скасували через погану погоду.)<br>\n" +
                                    "- <b>Owing to</b> – через, завдяки (більш формально)<br>\n" +
                                    "  - The flight was delayed <b>owing to</b> technical issues. (Рейс затримали через технічні проблеми.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'due to'?",
                            options = listOf("The flight was delayed due to the storm.", "The flight was due to delayed the storm.", "Due to the storm delayed the flight.", "The flight delayed due to the storm."),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Прийменникові конструкції для вираження способу</b><br>\n" +
                                    "- <b>By means of</b> – за допомогою<br>\n" +
                                    "  - He opened the door <b>by means of</b> a key. (Він відкрив двері за допомогою ключа.)<br>\n" +
                                    "- <b>In accordance with</b> – відповідно до<br>\n" +
                                    "  - The rules were changed <b>in accordance with</b> the new policy. (Правила змінили відповідно до нової політики.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'by means of'?",
                            options = listOf("Замість", "За допомогою", "Навпроти", "Окрім"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Прийменникові конструкції для вираження умов</b><br>\n" +
                                    "- <b>In case of</b> – у випадку<br>\n" +
                                    "  - <b>In case of</b> emergency, call 911. (У разі надзвичайної ситуації зателефонуйте 911.)<br>\n" +
                                    "- <b>On condition that</b> – за умови що<br>\n" +
                                    "  - You can go out <b>on condition that</b> you finish your homework. (Ти можеш піти, за умови, що виконаєш домашнє завдання.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Що означає 'in case of'?",
                            options = listOf("До певного моменту", "У разі", "Якщо ні", "Після цього"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 29,
                    title = "Розділ 29",
                    topic = "Використання 'have something done'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Використання 'have something done'</b><br>\n" +
                                    "Конструкція 'have something done' використовується для вираження дій, які виконуються іншими людьми для нас.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Формула конструкції</b><br>\n" +
                                    "- <b>have + object + past participle (V3)</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>had my car repaired</b> yesterday. (Мені відремонтували машину вчора.)<br>\n" +
                                    "- She <b>is having her hair cut</b> right now. (Їй зараз стрижуть волосся.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'have something done'?",
                            options = listOf("I have my car repairs.", "I had my car repaired.", "I have my car repairing.", "I had repairing my car."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання у різних часах</b><br>\n" +
                                    "- Конструкція може вживатися у будь-якому граматичному часі.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- Present Simple: I <b>have my house cleaned</b> every week. (Мій будинок прибирають щотижня.)<br>\n" +
                                    "- Past Simple: He <b>had his phone fixed</b> last month. (Йому відремонтували телефон минулого місяця.)<br>\n" +
                                    "- Future Simple: She <b>will have her dress made</b> next week. (Їй пошиють сукню наступного тижня.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно сказати про майбутню дію?",
                            options = listOf("I will have my car repairing.", "I will had my car repaired.", "I will have my car repaired.", "I have my car repaired tomorrow."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Використання в запитаннях та запереченнях</b><br>\n" +
                                    "- Для запитань використовуються допоміжні дієслова.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Did</b> you have your hair cut? (Тобі постригли волосся?)<br>\n" +
                                    "- <b>Have</b> you had your house painted recently? (Тобі недавно фарбували будинок?)<br>\n" +
                                    "- Заперечення: I <b>didn’t have</b> my phone repaired. (Мені не ремонтували телефон.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно утворити запитання?",
                            options = listOf("Had you your car repaired?", "Do you have your car repair?", "Did you have your car repaired?", "You had your car repaired?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Відмінність між 'have something done' та активним станом</b><br>\n" +
                                    "- 'Have something done' означає, що хтось робить дію для нас.<br>\n" +
                                    "- В активному стані виконувач дії відомий і стоїть у реченні.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- I <b>had my car washed</b>. (Мені помили машину.) – Пасивна дія<br>\n" +
                                    "- The mechanic <b>washed my car</b>. (Механік помив мою машину.) – Активна дія<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне у пасивній конструкції?",
                            options = listOf("I had washed my car.", "I had my car washed.", "I had washing my car.", "I have my car washes."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 30,
                    title = "Розділ 30",
                    topic = "Конструкція 'It takes'",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Конструкція 'It takes'</b><br>\n" +
                                    "Конструкція 'It takes' використовується для вираження часу, який потрібен на виконання дії.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Формула конструкції</b><br>\n" +
                                    "- <b>It takes + (someone) + time + to + verb</b><br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>It takes</b> me 10 minutes <b>to get</b> to work. (Мені потрібно 10 хвилин, щоб дістатися до роботи.)<br>\n" +
                                    "- <b>It took</b> him two hours <b>to finish</b> the project. (Йому знадобилося дві години, щоб завершити проєкт.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне з 'It takes'?",
                            options = listOf("It takes to me 5 minutes to walk there.", "It takes me 5 minutes to walk there.", "It takes 5 minutes me to walk there.", "It me takes 5 minutes to walk there."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Використання у різних часах</b><br>\n" +
                                    "- Конструкція 'It takes' може змінюватися залежно від часу.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- Present Simple: <b>It takes</b> me 30 minutes to cook dinner. (Приготування вечері займає у мене 30 хвилин.)<br>\n" +
                                    "- Past Simple: <b>It took</b> them three days to complete the task. (Виконання завдання зайняло у них три дні.)<br>\n" +
                                    "- Future Simple: <b>It will take</b> us an hour to fix the car. (Нам знадобиться година, щоб полагодити машину.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно сказати про майбутню дію?",
                            options = listOf("It take me an hour to do this.", "It will takes me an hour to do this.", "It will take me an hour to do this.", "It taking me an hour to do this."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Варіації конструкції</b><br>\n" +
                                    "- 'It takes' може використовуватися без уточнення, хто виконує дію.<br>\n" +
                                    "- 'It takes time' можна використовувати загально.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>It takes</b> time to learn a new language. (Вивчення нової мови займає час.)<br>\n" +
                                    "- <b>It takes</b> patience to deal with kids. (Робота з дітьми потребує терпіння.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення правильне?",
                            options = listOf("It takes patience dealing with kids.", "It takes patience to deal with kids.", "It takes patience deal with kids.", "It takes to patience deal with kids."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Альтернативні варіанти вираження часу</b><br>\n" +
                                    "- Інколи 'It takes' можна замінити іншими виразами.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>Spending</b> time on reading is useful. (Проведення часу за читанням корисне.)<br>\n" +
                                    "- Learning a new skill <b>requires</b> time. (Вивчення нової навички потребує часу.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке речення є правильною альтернативою 'It takes'?",
                            options = listOf("Reading takes time useful.", "Spending time on reading is useful.", "Time is takes for reading useful.", "To read takes useful time."),
                            correctAnswerIndex = 1
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_grammar_a2
        ),
        Course(
            id = 3,
            title = "Лексика",
            level = "Англійська рівень А1",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Привітання та знайомство",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Привітання та знайомство (Greetings and Introductions)</b><br>\n" +
                                    "Англійська мова має різні способи привітання залежно від ситуації.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні привітання</b><br>\n" +
                                    "- <b>Hello</b> – Привіт (універсальне вітання)<br>\n" +
                                    "- <b>Hi</b> – Привіт (неформальне)<br>\n" +
                                    "- <b>Good morning</b> – Добрий ранок (до 12:00)<br>\n" +
                                    "- <b>Good afternoon</b> – Добрий день (з 12:00 до 17:00)<br>\n" +
                                    "- <b>Good evening</b> – Добрий вечір (після 17:00)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке привітання використовується після 17:00?",
                            options = listOf("Good morning", "Good afternoon", "Good evening", "Hello"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як запитати, як справи?</b><br>\n" +
                                    "- <b>How are you?</b> – Як справи? (формальне)<br>\n" +
                                    "- <b>How’s it going?</b> – Як справи? (неформальне)<br>\n" +
                                    "- <b>What’s up?</b> – Як справи? (дуже неформальне)<br>\n" +
                                    "<b>Відповіді:</b><br>\n" +
                                    "- <b>I’m fine, thanks.</b> – У мене все добре, дякую.<br>\n" +
                                    "- <b>Not bad.</b> – Непогано.<br>\n" +
                                    "- <b>So-so.</b> – Так собі.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який із виразів є найменш формальним?",
                            options = listOf("How are you?", "How’s it going?", "What’s up?", "Good morning"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як представитися?</b><br>\n" +
                                    "- <b>My name is...</b> – Моє ім’я...<br>\n" +
                                    "- <b>I’m...</b> – Я... (більш неформально)<br>\n" +
                                    "- <b>Nice to meet you.</b> – Приємно познайомитися.<br>\n" +
                                    "- <b>Pleased to meet you.</b> – Радий познайомитися (формально)<br>\n" +
                                    "- <b>This is...</b> – Це... (коли представляємо когось)<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>My name is John.</b> – Мене звати Джон.<br>\n" +
                                    "- <b>Hi, I’m Anna.</b> – Привіт, я Анна.<br>\n" +
                                    "- <b>This is my friend, Mike.</b> – Це мій друг, Майк.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який вираз використовують для представлення когось іншого?",
                            options = listOf("My name is...", "I’m...", "Nice to meet you.", "This is..."),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як попрощатися?</b><br>\n" +
                                    "- <b>Goodbye</b> – До побачення (формально)<br>\n" +
                                    "- <b>Bye</b> – Бувай (неформально)<br>\n" +
                                    "- <b>See you later</b> – Побачимося пізніше.<br>\n" +
                                    "- <b>Take care</b> – Бережи себе.<br>\n" +
                                    "- <b>Have a nice day</b> – Гарного дня!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яке прощання є найбільш формальним?",
                            options = listOf("Bye", "See you later", "Goodbye", "Take care"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Числа та лічба",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Числа та лічба (Numbers and Counting)</b><br>\n" +
                                    "У англійській мові є два основні типи чисел: <b>кількісні (cardinal numbers)</b> та <b>порядкові (ordinal numbers)</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Кількісні числа (Cardinal Numbers)</b><br>\n" +
                                    "- Використовуються для позначення кількості чогось.<br>\n" +
                                    "<b>Основні числа:</b><br>\n" +
                                    "1 – one<br>\n" +
                                    "2 – two<br>\n" +
                                    "3 – three<br>\n" +
                                    "4 – four<br>\n" +
                                    "5 – five<br>\n" +
                                    "6 – six<br>\n" +
                                    "7 – seven<br>\n" +
                                    "8 – eight<br>\n" +
                                    "9 – nine<br>\n" +
                                    "10 – ten<br>\n" +
                                    "11 – eleven<br>\n" +
                                    "12 – twelve<br>\n" +
                                    "13 – thirteen<br>\n" +
                                    "20 – twenty<br>\n" +
                                    "30 – thirty<br>\n" +
                                    "40 – forty<br>\n" +
                                    "50 – fifty<br>\n" +
                                    "100 – one hundred<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде число 7?",
                            options = listOf("Four", "Seven", "Nine", "Eleven"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Порядкові числа (Ordinal Numbers)</b><br>\n" +
                                    "- Використовуються для позначення порядку предметів.<br>\n" +
                                    "<b>Основні порядкові числа:</b><br>\n" +
                                    "1st – first<br>\n" +
                                    "2nd – second<br>\n" +
                                    "3rd – third<br>\n" +
                                    "4th – fourth<br>\n" +
                                    "5th – fifth<br>\n" +
                                    "6th – sixth<br>\n" +
                                    "7th – seventh<br>\n" +
                                    "8th – eighth<br>\n" +
                                    "9th – ninth<br>\n" +
                                    "10th – tenth<br>\n" +
                                    "20th – twentieth<br>\n" +
                                    "30th – thirtieth<br>\n" +
                                    "100th – hundredth<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде порядкове число 'третій'?",
                            options = listOf("Third", "Three", "Thirty", "Thirty-three"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як запитати про кількість?</b><br>\n" +
                                    "- Щоб запитати про кількість предметів, використовують:<br>\n" +
                                    "- <b>How many</b> + злічувані іменники (many – багато)<br>\n" +
                                    "- <b>How much</b> + незлічувані іменники (much – багато)<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- <b>How many</b> apples do you have? (Скільки у тебе яблук?)<br>\n" +
                                    "- <b>How much</b> water do you need? (Скільки води тобі потрібно?)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який запит використовується для злічуваних предметів?",
                            options = listOf("How much", "How many", "How long", "How far"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Вимова складних чисел</b><br>\n" +
                                    "- Десятки та одиниці розділяються дефісом.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- 21 – twenty-one<br>\n" +
                                    "- 45 – forty-five<br>\n" +
                                    "- 99 – ninety-nine<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як правильно написати 88 англійською?",
                            options = listOf("Eighty eight", "Eight-eight", "Eighty-eight", "Eighty eighty"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Дні тижня, місяці, пори року",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Дні тижня, місяці, пори року (Days of the Week, Months, Seasons)</b><br>\n" +
                                    "У англійській мові назви днів тижня, місяців та пір року завжди пишуться з великої літери.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Дні тижня (Days of the Week)</b><br>\n" +
                                    "- Monday – понеділок<br>\n" +
                                    "- Tuesday – вівторок<br>\n" +
                                    "- Wednesday – середа<br>\n" +
                                    "- Thursday – четвер<br>\n" +
                                    "- Friday – п’ятниця<br>\n" +
                                    "- Saturday – субота<br>\n" +
                                    "- Sunday – неділя<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який день тижня йде після Wednesday?",
                            options = listOf("Monday", "Thursday", "Sunday", "Tuesday"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Місяці року (Months of the Year)</b><br>\n" +
                                    "- January – січень<br>\n" +
                                    "- February – лютий<br>\n" +
                                    "- March – березень<br>\n" +
                                    "- April – квітень<br>\n" +
                                    "- May – травень<br>\n" +
                                    "- June – червень<br>\n" +
                                    "- July – липень<br>\n" +
                                    "- August – серпень<br>\n" +
                                    "- September – вересень<br>\n" +
                                    "- October – жовтень<br>\n" +
                                    "- November – листопад<br>\n" +
                                    "- December – грудень<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Який місяць йде після April?",
                            options = listOf("March", "June", "May", "July"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Пори року (Seasons)</b><br>\n" +
                                    "- Spring – весна<br>\n" +
                                    "- Summer – літо<br>\n" +
                                    "- Autumn (Fall) – осінь<br>\n" +
                                    "- Winter – зима<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Яка пора року відповідає місяцю December?",
                            options = listOf("Summer", "Winter", "Spring", "Autumn"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні вирази</b><br>\n" +
                                    "- <b>What day is it today?</b> – Який сьогодні день?<br>\n" +
                                    "- <b>Today is Monday.</b> – Сьогодні понеділок.<br>\n" +
                                    "- <b>My birthday is in July.</b> – Мій день народження в липні.<br>\n" +
                                    "- <b>Autumn is my favorite season.</b> – Осінь – моя улюблена пора року.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Мій день народження в травні' англійською?",
                            options = listOf("My birthday is on May.", "My birthday is in May.", "My birthday May.", "My birthday is May."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Час та години",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Час та години (Telling the Time)</b><br>\n" +
                                    "В англійській мові є два основні способи говорити про час: <b>офіційний (24-годинний формат)</b> і <b>розмовний (12-годинний формат)</b>.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні запитання про час</b><br>\n" +
                                    "- <b>What time is it?</b> – Котра година?<br>\n" +
                                    "- <b>Do you have the time?</b> – Чи маєш ти годину? (неформальне)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати про час англійською?",
                            options = listOf("What is the time?", "How late is it?", "What time is it?", "Which hour is it?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як сказати час у розмовному форматі?</b><br>\n" +
                                    "- Використовується <b>past</b> (після) та <b>to</b> (до).<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- 3:10 – <b>Ten past three</b> (Десять хвилин по третій)<br>\n" +
                                    "- 4:45 – <b>Quarter to five</b> (Без п'ятнадцяти п'ята)<br>\n" +
                                    "- 9:30 – <b>Half past nine</b> (Половина десятого)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 7:15 у розмовному форматі?",
                            options = listOf("Quarter to seven", "Quarter past seven", "Half past seven", "Fifteen to seven"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як сказати час у 24-годинному форматі?</b><br>\n" +
                                    "- Використовується <b>o'clock</b> для повних годин.<br>\n" +
                                    "- Використовується <b>AM</b> (до полудня) та <b>PM</b> (після полудня) для точного часу.<br>\n" +
                                    "<b>Приклади:</b><br>\n" +
                                    "- 14:00 – <b>It’s two o’clock PM.</b> (Друга година дня.)<br>\n" +
                                    "- 08:30 – <b>It’s eight thirty AM.</b> (Вісім тридцять ранку.)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 10:00 у формальному стилі?",
                            options = listOf("It’s ten PM.", "It’s ten o’clock.", "It’s half past ten.", "It’s quarter past ten."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази для розмов про час</b><br>\n" +
                                    "- <b>What time does the meeting start?</b> – О котрій починається зустріч?<br>\n" +
                                    "- <b>It starts at 3 PM.</b> – Вона починається о третій дня.<br>\n" +
                                    "- <b>Can we meet at half past five?</b> – Ми можемо зустрітися о половині шостої?<br>\n" +
                                    "- <b>The train arrives at a quarter past seven.</b> – Потяг прибуває о чверть на восьму.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Зустріч о 16:30'?",
                            options = listOf("The meeting is at half past four.", "The meeting is at four o’clock.", "The meeting is at quarter to five.", "The meeting is at four past thirty."),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Родина та родинні зв’язки",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Родина та родинні зв’язки (Family and Relatives)</b><br>\n" +
                                    "Англійська мова має різні терміни для членів родини та родинних зв’язків.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Найближчі родичі (Immediate Family)</b><br>\n" +
                                    "- <b>Father</b> – батько<br>\n" +
                                    "- <b>Mother</b> – мати<br>\n" +
                                    "- <b>Parents</b> – батьки<br>\n" +
                                    "- <b>Son</b> – син<br>\n" +
                                    "- <b>Daughter</b> – дочка<br>\n" +
                                    "- <b>Brother</b> – брат<br>\n" +
                                    "- <b>Sister</b> – сестра<br>\n" +
                                    "- <b>Husband</b> – чоловік (у шлюбі)<br>\n" +
                                    "- <b>Wife</b> – дружина<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською 'сестра'?",
                            options = listOf("Mother", "Daughter", "Sister", "Aunt"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Дальші родичі (Extended Family)</b><br>\n" +
                                    "- <b>Grandfather</b> – дідусь<br>\n" +
                                    "- <b>Grandmother</b> – бабуся<br>\n" +
                                    "- <b>Grandparents</b> – дідусь і бабуся<br>\n" +
                                    "- <b>Uncle</b> – дядько<br>\n" +
                                    "- <b>Aunt</b> – тітка<br>\n" +
                                    "- <b>Cousin</b> – двоюрідний брат/сестра<br>\n" +
                                    "- <b>Nephew</b> – племінник<br>\n" +
                                    "- <b>Niece</b> – племінниця<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською 'дядько'?",
                            options = listOf("Nephew", "Uncle", "Grandfather", "Brother"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Родинні зв’язки через шлюб</b><br>\n" +
                                    "- <b>Father-in-law</b> – тесть/свекор<br>\n" +
                                    "- <b>Mother-in-law</b> – теща/свекруха<br>\n" +
                                    "- <b>Son-in-law</b> – зять (чоловік дочки)<br>\n" +
                                    "- <b>Daughter-in-law</b> – невістка (дружина сина)<br>\n" +
                                    "- <b>Brother-in-law</b> – шваґро (брат чоловіка/дружини)<br>\n" +
                                    "- <b>Sister-in-law</b> – зовиця (сестра чоловіка/дружини)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як називається брат чоловіка або дружини?",
                            options = listOf("Cousin", "Brother-in-law", "Nephew", "Son-in-law"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Інші важливі терміни</b><br>\n" +
                                    "- <b>Orphan</b> – сирота<br>\n" +
                                    "- <b>Stepfather</b> – вітчим<br>\n" +
                                    "- <b>Stepmother</b> – мачуха<br>\n" +
                                    "- <b>Stepbrother</b> – зведений брат<br>\n" +
                                    "- <b>Stepsister</b> – зведена сестра<br>\n" +
                                    "- <b>Twins</b> – близнюки<br>\n" +
                                    "- <b>Only child</b> – єдина дитина в сім'ї<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'мачуха' англійською?",
                            options = listOf("Mother-in-law", "Stepmother", "Aunt", "Grandmother"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази</b><br>\n" +
                                    "- <b>How many siblings do you have?</b> – Скільки у тебе братів і сестер?<br>\n" +
                                    "- <b>Do you have any cousins?</b> – У тебе є двоюрідні брати або сестри?<br>\n" +
                                    "- <b>I'm the youngest in my family.</b> – Я наймолодший у сім'ї.<br>\n" +
                                    "- <b>She is my mother’s sister.</b> – Вона сестра моєї мами.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати, скільки у людини братів та сестер?",
                            options = listOf("How many uncles do you have?", "Do you have any grandparents?", "How many siblings do you have?", "Are you an only child?"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Опис зовнішності та характеру",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Опис зовнішності та характеру (Describing Appearance and Personality)</b><br>\n" +
                                    "Щоб описати зовнішність людини та її характер, потрібно знати відповідну лексику.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Опис зовнішності (Describing Appearance)</b><br>\n" +
                                    "<b>Ріст:</b><br>\n" +
                                    "- Tall – високий<br>\n" +
                                    "- Short – низький<br>\n" +
                                    "- Medium height – середнього зросту<br>\n" +
                                    "<b>Статура:</b><br>\n" +
                                    "- Slim – стрункий<br>\n" +
                                    "- Fat – товстий<br>\n" +
                                    "- Muscular – м’язистий<br>\n" +
                                    "- Average build – середньої статури<br>\n" +
                                    "<b>Колір волосся:</b><br>\n" +
                                    "- Blonde – білявий<br>\n" +
                                    "- Brown – шатен<br>\n" +
                                    "- Black – чорний<br>\n" +
                                    "- Red – рудий<br>\n" +
                                    "- Grey – сивий<br>\n" +
                                    "<b>Довжина волосся:</b><br>\n" +
                                    "- Long – довге<br>\n" +
                                    "- Short – коротке<br>\n" +
                                    "- Shoulder-length – середньої довжини<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'високий' англійською?",
                            options = listOf("Short", "Tall", "Slim", "Muscular"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Опис рис обличчя (Facial Features)</b><br>\n" +
                                    "- Round face – кругле обличчя<br>\n" +
                                    "- Oval face – овальне обличчя<br>\n" +
                                    "- Square face – квадратне обличчя<br>\n" +
                                    "- Big eyes – великі очі<br>\n" +
                                    "- Small nose – маленький ніс<br>\n" +
                                    "- Full lips – повні губи<br>\n" +
                                    "- Thin lips – тонкі губи<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'повні губи' англійською?",
                            options = listOf("Thin lips", "Full lips", "Big lips", "Wide lips"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Опис характеру (Describing Personality)</b><br>\n" +
                                    "<b>Позитивні риси:</b><br>\n" +
                                    "- Friendly – дружелюбний<br>\n" +
                                    "- Kind – добрий<br>\n" +
                                    "- Honest – чесний<br>\n" +
                                    "- Smart – розумний<br>\n" +
                                    "- Hard-working – працьовитий<br>\n" +
                                    "- Generous – щедрий<br>\n" +
                                    "- Polite – ввічливий<br>\n" +
                                    "<b>Негативні риси:</b><br>\n" +
                                    "- Lazy – ледачий<br>\n" +
                                    "- Rude – грубий<br>\n" +
                                    "- Selfish – егоїстичний<br>\n" +
                                    "- Impatient – нетерплячий<br>\n" +
                                    "- Arrogant – зарозумілий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'чесний' англійською?",
                            options = listOf("Lazy", "Honest", "Friendly", "Generous"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази для опису людей</b><br>\n" +
                                    "- <b>She has long brown hair.</b> – У неї довге каштанове волосся.<br>\n" +
                                    "- <b>He is tall and slim.</b> – Він високий і стрункий.<br>\n" +
                                    "- <b>She is very kind and friendly.</b> – Вона дуже добра і дружелюбна.<br>\n" +
                                    "- <b>My brother is quite lazy.</b> – Мій брат досить ледачий.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Вона має довге біляве волосся' англійською?",
                            options = listOf("She is long blonde hair.", "She has long blonde hair.", "She have long blonde hair.", "She has blonde long hair."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Одяг та аксесуари",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Одяг та аксесуари (Clothing and Accessories)</b><br>\n" +
                                    "У англійській мові слова для одягу поділяються на різні категорії: повсякденний, формальний, спортивний тощо.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні предмети одягу (Basic Clothing Items)</b><br>\n" +
                                    "- <b>Shirt</b> – сорочка<br>\n" +
                                    "- <b>T-shirt</b> – футболка<br>\n" +
                                    "- <b>Jeans</b> – джинси<br>\n" +
                                    "- <b>Jacket</b> – куртка<br>\n" +
                                    "- <b>Coat</b> – пальто<br>\n" +
                                    "- <b>Dress</b> – сукня<br>\n" +
                                    "- <b>Skirt</b> – спідниця<br>\n" +
                                    "- <b>Sweater</b> – светр<br>\n" +
                                    "- <b>Pants</b> – штани (британський варіант: trousers)<br>\n" +
                                    "- <b>Shorts</b> – шорти<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'сорочка' англійською?",
                            options = listOf("Jacket", "Shirt", "T-shirt", "Sweater"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Взуття (Footwear)</b><br>\n" +
                                    "- <b>Shoes</b> – взуття<br>\n" +
                                    "- <b>Boots</b> – чоботи<br>\n" +
                                    "- <b>Sneakers</b> – кросівки<br>\n" +
                                    "- <b>Sandals</b> – сандалі<br>\n" +
                                    "- <b>Slippers</b> – капці<br>\n" +
                                    "- <b>High heels</b> – підбори<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською 'чоботи'?",
                            options = listOf("Sneakers", "Boots", "Slippers", "Shoes"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Аксесуари (Accessories)</b><br>\n" +
                                    "- <b>Hat</b> – капелюх<br>\n" +
                                    "- <b>Cap</b> – кепка<br>\n" +
                                    "- <b>Scarf</b> – шарф<br>\n" +
                                    "- <b>Gloves</b> – рукавички<br>\n" +
                                    "- <b>Belt</b> – пояс<br>\n" +
                                    "- <b>Watch</b> – годинник (наручний)<br>\n" +
                                    "- <b>Sunglasses</b> – сонцезахисні окуляри<br>\n" +
                                    "- <b>Backpack</b> – рюкзак<br>\n" +
                                    "- <b>Handbag</b> – жіноча сумка<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'шарф' англійською?",
                            options = listOf("Hat", "Scarf", "Gloves", "Belt"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Опис одягу (Describing Clothing)</b><br>\n" +
                                    "- <b>Casual</b> – повсякденний<br>\n" +
                                    "- <b>Formal</b> – офіційний<br>\n" +
                                    "- <b>Comfortable</b> – зручний<br>\n" +
                                    "- <b>Loose</b> – вільний<br>\n" +
                                    "- <b>Tight</b> – облягаючий<br>\n" +
                                    "- <b>Warm</b> – теплий<br>\n" +
                                    "- <b>Light</b> – легкий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'зручний' англійською?",
                            options = listOf("Formal", "Loose", "Comfortable", "Tight"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази</b><br>\n" +
                                    "- <b>What are you wearing?</b> – Що на тобі зараз?<br>\n" +
                                    "- <b>I’m wearing a blue shirt and jeans.</b> – На мені блакитна сорочка і джинси.<br>\n" +
                                    "- <b>Do you like my new dress?</b> – Тобі подобається моя нова сукня?<br>\n" +
                                    "- <b>These shoes are very comfortable.</b> – Це взуття дуже зручне.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Що на тобі зараз?' англійською?",
                            options = listOf("What do you wear?", "What are you wearing?", "What is your dress?", "Do you have new shoes?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Кольори",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Кольори (Colors)</b><br>\n" +
                                    "У англійській мові кольори використовуються для опису предметів, одягу, природи тощо.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні кольори (Basic Colors)</b><br>\n" +
                                    "- <b>Red</b> – червоний<br>\n" +
                                    "- <b>Blue</b> – синій<br>\n" +
                                    "- <b>Yellow</b> – жовтий<br>\n" +
                                    "- <b>Green</b> – зелений<br>\n" +
                                    "- <b>Orange</b> – оранжевий<br>\n" +
                                    "- <b>Purple</b> – фіолетовий<br>\n" +
                                    "- <b>Pink</b> – рожевий<br>\n" +
                                    "- <b>Brown</b> – коричневий<br>\n" +
                                    "- <b>Black</b> – чорний<br>\n" +
                                    "- <b>White</b> – білий<br>\n" +
                                    "- <b>Gray (Grey)</b> – сірий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'жовтий'?",
                            options = listOf("Red", "Green", "Yellow", "Purple"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Відтінки кольорів (Shades of Colors)</b><br>\n" +
                                    "- <b>Light blue</b> – світло-синій<br>\n" +
                                    "- <b>Dark green</b> – темно-зелений<br>\n" +
                                    "- <b>Bright red</b> – яскраво-червоний<br>\n" +
                                    "- <b>Pale yellow</b> – блідо-жовтий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'темно-зелений' англійською?",
                            options = listOf("Light green", "Bright green", "Dark green", "Pale green"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як описати кольори</b><br>\n" +
                                    "- <b>The sky is blue.</b> – Небо блакитне.<br>\n" +
                                    "- <b>She has brown eyes.</b> – У неї карі очі.<br>\n" +
                                    "- <b>I like red flowers.</b> – Мені подобаються червоні квіти.<br>\n" +
                                    "- <b>He bought a black car.</b> – Він купив чорну машину.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Небо блакитне' англійською?",
                            options = listOf("The sky is red.", "The sky is blue.", "The sun is blue.", "The sky is yellow."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази</b><br>\n" +
                                    "- <b>What’s your favorite color?</b> – Який твій улюблений колір?<br>\n" +
                                    "- <b>My favorite color is green.</b> – Мій улюблений колір – зелений.<br>\n" +
                                    "- <b>This dress is too bright.</b> – Ця сукня занадто яскрава.<br>\n" +
                                    "- <b>Do you prefer dark or light colors?</b> – Тобі більше подобаються темні чи світлі кольори?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Який твій улюблений колір?' англійською?",
                            options = listOf("What color do you have?", "What’s your favorite color?", "Which color are you?", "Do you like blue?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Їжа та напої",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Їжа та напої (Food and Drinks)</b><br>\n" +
                                    "Англійська мова має багато слів для позначення різних видів їжі та напоїв.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні продукти харчування (Basic Food Items)</b><br>\n" +
                                    "- <b>Bread</b> – хліб<br>\n" +
                                    "- <b>Rice</b> – рис<br>\n" +
                                    "- <b>Pasta</b> – макарони<br>\n" +
                                    "- <b>Eggs</b> – яйця<br>\n" +
                                    "- <b>Cheese</b> – сир<br>\n" +
                                    "- <b>Butter</b> – масло<br>\n" +
                                    "- <b>Milk</b> – молоко<br>\n" +
                                    "- <b>Meat</b> – м’ясо<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'молоко'?",
                            options = listOf("Bread", "Milk", "Cheese", "Butter"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Фрукти та овочі (Fruits and Vegetables)</b><br>\n" +
                                    "- <b>Apple</b> – яблуко<br>\n" +
                                    "- <b>Banana</b> – банан<br>\n" +
                                    "- <b>Orange</b> – апельсин<br>\n" +
                                    "- <b>Grapes</b> – виноград<br>\n" +
                                    "- <b>Carrot</b> – морква<br>\n" +
                                    "- <b>Tomato</b> – помідор<br>\n" +
                                    "- <b>Cucumber</b> – огірок<br>\n" +
                                    "- <b>Potato</b> – картопля<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'яблуко' англійською?",
                            options = listOf("Banana", "Apple", "Grapes", "Orange"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Напої (Drinks)</b><br>\n" +
                                    "- <b>Water</b> – вода<br>\n" +
                                    "- <b>Tea</b> – чай<br>\n" +
                                    "- <b>Coffee</b> – кава<br>\n" +
                                    "- <b>Juice</b> – сік<br>\n" +
                                    "- <b>Milkshake</b> – молочний коктейль<br>\n" +
                                    "- <b>Soda</b> – газований напій<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською 'чай'?",
                            options = listOf("Coffee", "Juice", "Tea", "Soda"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Основні страви (Meals)</b><br>\n" +
                                    "- <b>Breakfast</b> – сніданок<br>\n" +
                                    "- <b>Lunch</b> – обід<br>\n" +
                                    "- <b>Dinner</b> – вечеря<br>\n" +
                                    "- <b>Snack</b> – перекус<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'сніданок' англійською?",
                            options = listOf("Dinner", "Lunch", "Breakfast", "Snack"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази</b><br>\n" +
                                    "- <b>What would you like to eat?</b> – Що б ти хотів з’їсти?<br>\n" +
                                    "- <b>Can I have a cup of coffee?</b> – Можна мені чашку кави?<br>\n" +
                                    "- <b>This soup is delicious.</b> – Цей суп дуже смачний.<br>\n" +
                                    "- <b>I am hungry.</b> – Я голодний.<br>\n" +
                                    "- <b>Would you like some tea?</b> – Хочеш трохи чаю?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я голодний' англійською?",
                            options = listOf("I am full.", "I am hungry.", "I am thirsty.", "I am sleepy."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "У магазині: покупки, ціни",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>У магазині: покупки, ціни (Shopping and Prices)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як запитувати про ціни, робити покупки та розмовляти з продавцем у магазині.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні типи магазинів (Types of Shops)</b><br>\n" +
                                    "- <b>Supermarket</b> – супермаркет<br>\n" +
                                    "- <b>Grocery store</b> – продуктовий магазин<br>\n" +
                                    "- <b>Clothing store</b> – магазин одягу<br>\n" +
                                    "- <b>Shoe shop</b> – магазин взуття<br>\n" +
                                    "- <b>Bookstore</b> – книжковий магазин<br>\n" +
                                    "- <b>Pharmacy</b> – аптека<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'книжковий магазин' англійською?",
                            options = listOf("Grocery store", "Bookstore", "Supermarket", "Clothing store"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як запитати про ціну? (Asking About Prices)</b><br>\n" +
                                    "- <b>How much does it cost?</b> – Скільки це коштує?<br>\n" +
                                    "- <b>What’s the price of this?</b> – Яка ціна цього?<br>\n" +
                                    "- <b>It costs $10.</b> – Це коштує 10 доларів.<br>\n" +
                                    "- <b>That’s too expensive!</b> – Це занадто дорого!<br>\n" +
                                    "- <b>Do you have any discounts?</b> – У вас є знижки?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати про ціну англійською?",
                            options = listOf("What much is it?", "How much does it cost?", "How price is it?", "What price are this?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Опис цін (Describing Prices)</b><br>\n" +
                                    "- <b>Cheap</b> – дешевий<br>\n" +
                                    "- <b>Expensive</b> – дорогий<br>\n" +
                                    "- <b>Affordable</b> – доступний за ціною<br>\n" +
                                    "- <b>On sale</b> – у продажу зі знижкою<br>\n" +
                                    "- <b>Half price</b> – за пів ціни<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'доступний за ціною' англійською?",
                            options = listOf("Cheap", "Affordable", "Expensive", "On sale"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як попросити щось у магазині? (How to Ask for Something in a Store)</b><br>\n" +
                                    "- <b>Can I have this in a smaller size?</b> – Чи є це в меншому розмірі?<br>\n" +
                                    "- <b>Do you have this in another color?</b> – Чи є це в іншому кольорі?<br>\n" +
                                    "- <b>Can I try it on?</b> – Можу я це приміряти?<br>\n" +
                                    "- <b>Where can I pay?</b> – Де я можу заплатити?<br>\n" +
                                    "- <b>Do you accept credit cards?</b> – Ви приймаєте кредитні картки?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чи можу я це приміряти?' англійською?",
                            options = listOf("Can I take it?", "Can I wear it?", "Can I try it on?", "Can I hold it?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази</b><br>\n" +
                                    "- <b>I’m just looking, thanks.</b> – Я просто дивлюся, дякую.<br>\n" +
                                    "- <b>Can I get a receipt, please?</b> – Чи можу я отримати чек?<br>\n" +
                                    "- <b>That’s a great deal!</b> – Це вигідна пропозиція!<br>\n" +
                                    "- <b>Do you have a loyalty card?</b> – У вас є картка постійного клієнта?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я просто дивлюся, дякую' англійською?",
                            options = listOf("I am looking for something.", "I’m just looking, thanks.", "I am looking at the store.", "I’m just watching, thanks."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Житло: кімнати, меблі, побутові речі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Житло: кімнати, меблі, побутові речі (Home: Rooms, Furniture, Household Items)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як називати різні частини будинку, меблі та побутові речі англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Частини будинку (Parts of the House)</b><br>\n" +
                                    "- <b>Living room</b> – вітальня<br>\n" +
                                    "- <b>Bedroom</b> – спальня<br>\n" +
                                    "- <b>Kitchen</b> – кухня<br>\n" +
                                    "- <b>Bathroom</b> – ванна кімната<br>\n" +
                                    "- <b>Dining room</b> – їдальня<br>\n" +
                                    "- <b>Hallway</b> – коридор<br>\n" +
                                    "- <b>Basement</b> – підвал<br>\n" +
                                    "- <b>Balcony</b> – балкон<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'спальня' англійською?",
                            options = listOf("Kitchen", "Bedroom", "Living room", "Bathroom"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Меблі (Furniture)</b><br>\n" +
                                    "- <b>Bed</b> – ліжко<br>\n" +
                                    "- <b>Sofa</b> – диван<br>\n" +
                                    "- <b>Table</b> – стіл<br>\n" +
                                    "- <b>Chair</b> – стілець<br>\n" +
                                    "- <b>Wardrobe</b> – шафа для одягу<br>\n" +
                                    "- <b>Bookshelf</b> – книжкова полиця<br>\n" +
                                    "- <b>Desk</b> – письмовий стіл<br>\n" +
                                    "- <b>Mirror</b> – дзеркало<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'шафа для одягу' англійською?",
                            options = listOf("Bookshelf", "Chair", "Wardrobe", "Sofa"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Побутові речі (Household Items)</b><br>\n" +
                                    "- <b>Fridge</b> – холодильник<br>\n" +
                                    "- <b>Oven</b> – духовка<br>\n" +
                                    "- <b>Microwave</b> – мікрохвильова піч<br>\n" +
                                    "- <b>Washing machine</b> – пральна машина<br>\n" +
                                    "- <b>Vacuum cleaner</b> – пилосос<br>\n" +
                                    "- <b>Television (TV)</b> – телевізор<br>\n" +
                                    "- <b>Clock</b> – годинник<br>\n" +
                                    "- <b>Lamp</b> – лампа<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'холодильник' англійською?",
                            options = listOf("Microwave", "Oven", "Fridge", "Washing machine"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Опис житла (Describing a Home)</b><br>\n" +
                                    "- <b>Big</b> – великий<br>\n" +
                                    "- <b>Small</b> – маленький<br>\n" +
                                    "- <b>Cozy</b> – затишний<br>\n" +
                                    "- <b>Modern</b> – сучасний<br>\n" +
                                    "- <b>Traditional</b> – традиційний<br>\n" +
                                    "- <b>Spacious</b> – просторий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'затишний' англійською?",
                            options = listOf("Modern", "Cozy", "Spacious", "Small"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази</b><br>\n" +
                                    "- <b>Where is the bathroom?</b> – Де знаходиться ванна кімната?<br>\n" +
                                    "- <b>My bedroom is small but cozy.</b> – Моя спальня маленька, але затишна.<br>\n" +
                                    "- <b>We have a big kitchen.</b> – У нас велика кухня.<br>\n" +
                                    "- <b>Can you clean the living room?</b> – Можеш прибрати вітальню?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Моя спальня маленька, але затишна' англійською?",
                            options = listOf("My bedroom is big and modern.", "My bedroom is small but cozy.", "My bathroom is small but clean.", "My living room is small but spacious."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Місто та місця в місті",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Місто та місця в місті (City and Places in the City)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як називати основні місця в місті та запитувати дорогу англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні місця в місті (Common Places in the City)</b><br>\n" +
                                    "- <b>Park</b> – парк<br>\n" +
                                    "- <b>Library</b> – бібліотека<br>\n" +
                                    "- <b>School</b> – школа<br>\n" +
                                    "- <b>University</b> – університет<br>\n" +
                                    "- <b>Hospital</b> – лікарня<br>\n" +
                                    "- <b>Bank</b> – банк<br>\n" +
                                    "- <b>Police station</b> – поліцейський відділок<br>\n" +
                                    "- <b>Post office</b> – поштове відділення<br>\n" +
                                    "- <b>Museum</b> – музей<br>\n" +
                                    "- <b>Theater</b> – театр<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'лікарня'?",
                            options = listOf("Library", "Hospital", "Museum", "University"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Транспорт та дороги (Transport and Roads)</b><br>\n" +
                                    "- <b>Street</b> – вулиця<br>\n" +
                                    "- <b>Avenue</b> – проспект<br>\n" +
                                    "- <b>Bridge</b> – міст<br>\n" +
                                    "- <b>Traffic light</b> – світлофор<br>\n" +
                                    "- <b>Bus stop</b> – автобусна зупинка<br>\n" +
                                    "- <b>Train station</b> – залізничний вокзал<br>\n" +
                                    "- <b>Airport</b> – аеропорт<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'автобусна зупинка' англійською?",
                            options = listOf("Bus station", "Bus stop", "Train stop", "Airport"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як запитати дорогу? (Asking for Directions)</b><br>\n" +
                                    "- <b>Excuse me, how do I get to the library?</b> – Вибачте, як дістатися до бібліотеки?<br>\n" +
                                    "- <b>Where is the nearest bank?</b> – Де знаходиться найближчий банк?<br>\n" +
                                    "- <b>Go straight ahead.</b> – Йдіть прямо.<br>\n" +
                                    "- <b>Turn left.</b> – Поверніть ліворуч.<br>\n" +
                                    "- <b>Turn right.</b> – Поверніть праворуч.<br>\n" +
                                    "- <b>It’s on the corner.</b> – Це на розі.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Поверніть праворуч' англійською?",
                            options = listOf("Go straight ahead", "Turn left", "Turn right", "Go back"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази для розмов у місті</b><br>\n" +
                                    "- <b>Can you help me find the bus stop?</b> – Ви можете допомогти мені знайти автобусну зупинку?<br>\n" +
                                    "- <b>How far is the train station?</b> – Як далеко до залізничного вокзалу?<br>\n" +
                                    "- <b>The museum is next to the park.</b> – Музей знаходиться поруч із парком.<br>\n" +
                                    "- <b>The bank is across the street.</b> – Банк знаходиться через дорогу.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Музей знаходиться поруч із парком' англійською?",
                            options = listOf("The museum is across the street.", "The museum is next to the park.", "The museum is between the bank and the post office.", "The museum is behind the theater."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 13,
                    title = "Розділ 13",
                    topic = "Транспорт та подорожі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Транспорт та подорожі (Transport and Travel)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як говорити про різні види транспорту та подорожі англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види транспорту (Types of Transport)</b><br>\n" +
                                    "- <b>Car</b> – автомобіль<br>\n" +
                                    "- <b>Bus</b> – автобус<br>\n" +
                                    "- <b>Train</b> – потяг<br>\n" +
                                    "- <b>Plane</b> – літак<br>\n" +
                                    "- <b>Ship</b> – корабель<br>\n" +
                                    "- <b>Bicycle</b> – велосипед<br>\n" +
                                    "- <b>Motorcycle</b> – мотоцикл<br>\n" +
                                    "- <b>Taxi</b> – таксі<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'автобус'?",
                            options = listOf("Car", "Bus", "Train", "Taxi"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як запитати про транспорт? (Asking About Transport)</b><br>\n" +
                                    "- <b>How can I get to the airport?</b> – Як мені дістатися до аеропорту?<br>\n" +
                                    "- <b>Which bus goes to the city center?</b> – Який автобус їде в центр міста?<br>\n" +
                                    "- <b>Where is the nearest train station?</b> – Де знаходиться найближча залізнична станція?<br>\n" +
                                    "- <b>What time does the next flight leave?</b> – О котрій вилітає наступний рейс?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Де знаходиться найближча залізнична станція?' англійською?",
                            options = listOf("Where is the next airport?", "Where is the nearest train station?", "Where goes the train?", "Where is the train airport?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. У подорожі (On a Trip)</b><br>\n" +
                                    "- <b>Passport</b> – паспорт<br>\n" +
                                    "- <b>Ticket</b> – квиток<br>\n" +
                                    "- <b>Boarding pass</b> – посадковий талон<br>\n" +
                                    "- <b>Luggage</b> – багаж<br>\n" +
                                    "- <b>Suitcase</b> – валіза<br>\n" +
                                    "- <b>Customs</b> – митниця<br>\n" +
                                    "- <b>Hotel</b> – готель<br>\n" +
                                    "- <b>Reservation</b> – бронювання<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'квиток' англійською?",
                            options = listOf("Luggage", "Boarding pass", "Ticket", "Passport"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази для подорожей</b><br>\n" +
                                    "- <b>I would like to book a ticket.</b> – Я хочу забронювати квиток.<br>\n" +
                                    "- <b>What time is my flight?</b> – О котрій мій рейс?<br>\n" +
                                    "- <b>Where can I find a taxi?</b> – Де я можу знайти таксі?<br>\n" +
                                    "- <b>Can I have a window seat?</b> – Чи можу я отримати місце біля вікна?<br>\n" +
                                    "- <b>How much is a ticket to London?</b> – Скільки коштує квиток до Лондона?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Де я можу знайти таксі?' англійською?",
                            options = listOf("Where is my train?", "Where can I find a taxi?", "Where does the bus go?", "Where is my luggage?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 14,
                    title = "Розділ 14",
                    topic = "Погода та природні явища",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Погода та природні явища (Weather and Natural Phenomena)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як описувати погоду та природні явища англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні слова про погоду (Basic Weather Vocabulary)</b><br>\n" +
                                    "- <b>Sunny</b> – сонячно<br>\n" +
                                    "- <b>Cloudy</b> – хмарно<br>\n" +
                                    "- <b>Rainy</b> – дощова погода<br>\n" +
                                    "- <b>Windy</b> – вітряно<br>\n" +
                                    "- <b>Snowy</b> – сніжно<br>\n" +
                                    "- <b>Foggy</b> – туманно<br>\n" +
                                    "- <b>Stormy</b> – штормова погода<br>\n" +
                                    "- <b>Cold</b> – холодно<br>\n" +
                                    "- <b>Hot</b> – спекотно<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'сонячно'?",
                            options = listOf("Cloudy", "Rainy", "Sunny", "Windy"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Природні явища (Natural Phenomena)</b><br>\n" +
                                    "- <b>Rainbow</b> – веселка<br>\n" +
                                    "- <b>Lightning</b> – блискавка<br>\n" +
                                    "- <b>Thunder</b> – грім<br>\n" +
                                    "- <b>Hurricane</b> – ураган<br>\n" +
                                    "- <b>Tornado</b> – торнадо<br>\n" +
                                    "- <b>Earthquake</b> – землетрус<br>\n" +
                                    "- <b>Flood</b> – повінь<br>\n" +
                                    "- <b>Volcano</b> – вулкан<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'блискавка' англійською?",
                            options = listOf("Thunder", "Lightning", "Rainbow", "Flood"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як описати погоду? (Describing the Weather)</b><br>\n" +
                                    "- <b>It’s sunny today.</b> – Сьогодні сонячно.<br>\n" +
                                    "- <b>It’s very cold outside.</b> – На вулиці дуже холодно.<br>\n" +
                                    "- <b>It’s raining heavily.</b> – Йде сильний дощ.<br>\n" +
                                    "- <b>The wind is blowing hard.</b> – Вітер сильно дме.<br>\n" +
                                    "- <b>There is a thunderstorm.</b> – Починається гроза.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'На вулиці дуже холодно' англійською?",
                            options = listOf("It’s sunny outside.", "It’s very cold outside.", "It’s raining outside.", "It’s windy outside."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як запитати про погоду? (Asking About the Weather)</b><br>\n" +
                                    "- <b>What’s the weather like today?</b> – Яка сьогодні погода?<br>\n" +
                                    "- <b>Is it going to rain?</b> – Чи буде дощ?<br>\n" +
                                    "- <b>How cold is it outside?</b> – Наскільки холодно на вулиці?<br>\n" +
                                    "- <b>What’s the temperature?</b> – Яка температура?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Яка сьогодні погода?' англійською?",
                            options = listOf("What is the weather today?", "What’s the weather like today?", "How is the weather today?", "What weather is it?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 15,
                    title = "Розділ 15",
                    topic = "Захоплення та хобі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Захоплення та хобі (Hobbies and Interests)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як говорити про свої хобі та улюблені заняття англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Популярні хобі (Popular Hobbies)</b><br>\n" +
                                    "- <b>Reading</b> – читання<br>\n" +
                                    "- <b>Painting</b> – малювання<br>\n" +
                                    "- <b>Photography</b> – фотографія<br>\n" +
                                    "- <b>Playing musical instruments</b> – гра на музичних інструментах<br>\n" +
                                    "- <b>Cooking</b> – кулінарія<br>\n" +
                                    "- <b>Gardening</b> – садівництво<br>\n" +
                                    "- <b>Fishing</b> – риболовля<br>\n" +
                                    "- <b>Traveling</b> – подорожі<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'подорожі'?",
                            options = listOf("Fishing", "Traveling", "Painting", "Reading"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Спортивні хобі (Sports and Active Hobbies)</b><br>\n" +
                                    "- <b>Swimming</b> – плавання<br>\n" +
                                    "- <b>Running</b> – біг<br>\n" +
                                    "- <b>Cycling</b> – катання на велосипеді<br>\n" +
                                    "- <b>Hiking</b> – піші походи<br>\n" +
                                    "- <b>Yoga</b> – йога<br>\n" +
                                    "- <b>Martial arts</b> – бойові мистецтва<br>\n" +
                                    "- <b>Skating</b> – катання на ковзанах<br>\n" +
                                    "- <b>Skiing</b> – катання на лижах<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'плавання' англійською?",
                            options = listOf("Cycling", "Running", "Swimming", "Hiking"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як говорити про свої хобі? (Talking About Hobbies)</b><br>\n" +
                                    "- <b>What are your hobbies?</b> – Які твої хобі?<br>\n" +
                                    "- <b>I enjoy painting.</b> – Мені подобається малювати.<br>\n" +
                                    "- <b>My favorite hobby is reading books.</b> – Моє улюблене хобі – читання книг.<br>\n" +
                                    "- <b>In my free time, I like cooking.</b> – У вільний час я люблю готувати.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Мені подобається малювати' англійською?",
                            options = listOf("I enjoy painting.", "I enjoy fishing.", "I like yoga.", "I love hiking."),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Корисні фрази</b><br>\n" +
                                    "- <b>Do you have any hobbies?</b> – У тебе є хобі?<br>\n" +
                                    "- <b>How often do you go hiking?</b> – Як часто ти ходиш у похід?<br>\n" +
                                    "- <b>I spend a lot of time playing the guitar.</b> – Я проводжу багато часу, граючи на гітарі.<br>\n" +
                                    "- <b>My brother is interested in photography.</b> – Мій брат цікавиться фотографією.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'У тебе є хобі?' англійською?",
                            options = listOf("Do you have any hobbies?", "What are you doing?", "Do you like traveling?", "Are you interested in music?"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 16,
                    title = "Розділ 16",
                    topic = "Тварини та природа",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Тварини та природа (Animals and Nature)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як називати різні види тварин, природні середовища та описувати природу англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Домашні тварини (Pets)</b><br>\n" +
                                    "- <b>Dog</b> – собака<br>\n" +
                                    "- <b>Cat</b> – кіт<br>\n" +
                                    "- <b>Fish</b> – риба<br>\n" +
                                    "- <b>Hamster</b> – хом’як<br>\n" +
                                    "- <b>Parrot</b> – папуга<br>\n" +
                                    "- <b>Rabbit</b> – кролик<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'кіт'?",
                            options = listOf("Dog", "Fish", "Cat", "Rabbit"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Дикі тварини (Wild Animals)</b><br>\n" +
                                    "- <b>Lion</b> – лев<br>\n" +
                                    "- <b>Elephant</b> – слон<br>\n" +
                                    "- <b>Tiger</b> – тигр<br>\n" +
                                    "- <b>Bear</b> – ведмідь<br>\n" +
                                    "- <b>Wolf</b> – вовк<br>\n" +
                                    "- <b>Fox</b> – лисиця<br>\n" +
                                    "- <b>Giraffe</b> – жираф<br>\n" +
                                    "- <b>Monkey</b> – мавпа<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'тигр' англійською?",
                            options = listOf("Bear", "Fox", "Tiger", "Monkey"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Природні середовища (Natural Habitats)</b><br>\n" +
                                    "- <b>Forest</b> – ліс<br>\n" +
                                    "- <b>Jungle</b> – джунглі<br>\n" +
                                    "- <b>Desert</b> – пустеля<br>\n" +
                                    "- <b>Mountain</b> – гора<br>\n" +
                                    "- <b>River</b> – річка<br>\n" +
                                    "- <b>Lake</b> – озеро<br>\n" +
                                    "- <b>Ocean</b> – океан<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'озеро'?",
                            options = listOf("River", "Lake", "Mountain", "Ocean"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Пори року та погода (Seasons and Weather)</b><br>\n" +
                                    "- <b>Spring</b> – весна<br>\n" +
                                    "- <b>Summer</b> – літо<br>\n" +
                                    "- <b>Autumn (Fall)</b> – осінь<br>\n" +
                                    "- <b>Winter</b> – зима<br>\n" +
                                    "- <b>Rain</b> – дощ<br>\n" +
                                    "- <b>Snow</b> – сніг<br>\n" +
                                    "- <b>Storm</b> – шторм<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'зима' англійською?",
                            options = listOf("Spring", "Summer", "Winter", "Autumn"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про природу</b><br>\n" +
                                    "- <b>The sky is blue.</b> – Небо блакитне.<br>\n" +
                                    "- <b>The river is very deep.</b> – Річка дуже глибока.<br>\n" +
                                    "- <b>I love hiking in the mountains.</b> – Я люблю ходити в гори.<br>\n" +
                                    "- <b>The lion is the king of the jungle.</b> – Лев – король джунглів.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Лев – король джунглів' англійською?",
                            options = listOf("The lion is the king of the jungle.", "The lion is the king of the ocean.", "The tiger is the king of the jungle.", "The monkey is the king of the jungle."),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 17,
                    title = "Розділ 17",
                    topic = "Школа та навчання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Школа та навчання (School and Education)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основну лексику, пов'язану з навчанням, предметами, шкільним приладдям та корисними фразами для навчального процесу.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Частини школи (Parts of a School)</b><br>\n" +
                                    "- <b>Classroom</b> – класна кімната<br>\n" +
                                    "- <b>Library</b> – бібліотека<br>\n" +
                                    "- <b>Gym</b> – спортивний зал<br>\n" +
                                    "- <b>Cafeteria</b> – їдальня<br>\n" +
                                    "- <b>Playground</b> – ігровий майданчик<br>\n" +
                                    "- <b>Teacher’s office</b> – кабінет вчителя<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'бібліотека'?",
                            options = listOf("Classroom", "Library", "Gym", "Playground"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Шкільні предмети (School Subjects)</b><br>\n" +
                                    "- <b>Mathematics (Math)</b> – математика<br>\n" +
                                    "- <b>English</b> – англійська мова<br>\n" +
                                    "- <b>Science</b> – природничі науки<br>\n" +
                                    "- <b>History</b> – історія<br>\n" +
                                    "- <b>Geography</b> – географія<br>\n" +
                                    "- <b>Biology</b> – біологія<br>\n" +
                                    "- <b>Physics</b> – фізика<br>\n" +
                                    "- <b>Chemistry</b> – хімія<br>\n" +
                                    "- <b>Art</b> – мистецтво<br>\n" +
                                    "- <b>Music</b> – музика<br>\n" +
                                    "- <b>Physical Education (PE)</b> – фізична культура<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'фізика' англійською?",
                            options = listOf("Biology", "Chemistry", "Physics", "History"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Шкільне приладдя (School Supplies)</b><br>\n" +
                                    "- <b>Notebook</b> – зошит<br>\n" +
                                    "- <b>Pen</b> – ручка<br>\n" +
                                    "- <b>Pencil</b> – олівець<br>\n" +
                                    "- <b>Eraser</b> – гумка<br>\n" +
                                    "- <b>Ruler</b> – лінійка<br>\n" +
                                    "- <b>Backpack</b> – рюкзак<br>\n" +
                                    "- <b>Marker</b> – маркер<br>\n" +
                                    "- <b>Scissors</b> – ножиці<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'ручка' англійською?",
                            options = listOf("Pencil", "Notebook", "Pen", "Marker"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Освітні рівні та заклади (Education Levels and Institutions)</b><br>\n" +
                                    "- <b>Kindergarten</b> – дитячий садок<br>\n" +
                                    "- <b>Elementary school</b> – початкова школа<br>\n" +
                                    "- <b>Middle school</b> – середня школа (5-8 класи)<br>\n" +
                                    "- <b>High school</b> – старша школа (9-12 класи)<br>\n" +
                                    "- <b>University</b> – університет<br>\n" +
                                    "- <b>College</b> – коледж<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською 'дитячий садок'?",
                            options = listOf("Middle school", "Kindergarten", "University", "High school"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази у школі (Useful Phrases in School)</b><br>\n" +
                                    "- <b>What subject do you like the most?</b> – Який предмет тобі подобається найбільше?<br>\n" +
                                    "- <b>I have a math test tomorrow.</b> – Завтра у мене тест з математики.<br>\n" +
                                    "- <b>Can I borrow a pencil?</b> – Можу я позичити олівець?<br>\n" +
                                    "- <b>Raise your hand if you know the answer.</b> – Підніміть руку, якщо знаєте відповідь.<br>\n" +
                                    "- <b>The lesson starts at 8 AM.</b> – Урок починається о 8-й ранку.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Урок починається о 8-й ранку' англійською?",
                            options = listOf("The lesson ends at 8 AM.", "The lesson starts at 8 AM.", "The lesson finishes at 8 AM.", "The lesson is over at 8 AM."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 18,
                    title = "Розділ 18",
                    topic = "Комп’ютери та технології",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Комп’ютери та технології (Computers and Technology)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основні терміни, пов'язані з комп’ютерами, Інтернетом, гаджетами та програмним забезпеченням.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Частини комп’ютера (Computer Parts)</b><br>\n" +
                                    "- <b>Monitor</b> – монітор<br>\n" +
                                    "- <b>Keyboard</b> – клавіатура<br>\n" +
                                    "- <b>Mouse</b> – миша<br>\n" +
                                    "- <b>Processor</b> – процесор<br>\n" +
                                    "- <b>Hard drive</b> – жорсткий диск<br>\n" +
                                    "- <b>USB port</b> – USB-порт<br>\n" +
                                    "- <b>Graphics card</b> – відеокарта<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'клавіатура'?",
                            options = listOf("Monitor", "Mouse", "Keyboard", "Processor"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Гаджети та пристрої (Gadgets and Devices)</b><br>\n" +
                                    "- <b>Smartphone</b> – смартфон<br>\n" +
                                    "- <b>Tablet</b> – планшет<br>\n" +
                                    "- <b>Laptop</b> – ноутбук<br>\n" +
                                    "- <b>Desktop computer</b> – стаціонарний комп’ютер<br>\n" +
                                    "- <b>Smartwatch</b> – розумний годинник<br>\n" +
                                    "- <b>Headphones</b> – навушники<br>\n" +
                                    "- <b>Printer</b> – принтер<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'ноутбук' англійською?",
                            options = listOf("Tablet", "Desktop computer", "Laptop", "Printer"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Інтернет та комунікації (Internet and Communication)</b><br>\n" +
                                    "- <b>Website</b> – вебсайт<br>\n" +
                                    "- <b>Email</b> – електронна пошта<br>\n" +
                                    "- <b>Social media</b> – соціальні мережі<br>\n" +
                                    "- <b>Wi-Fi</b> – вай-фай<br>\n" +
                                    "- <b>Search engine</b> – пошукова система<br>\n" +
                                    "- <b>Online shopping</b> – онлайн-шопінг<br>\n" +
                                    "- <b>Download</b> – завантажити<br>\n" +
                                    "- <b>Upload</b> – завантажити (викласти)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'пошукова система' англійською?",
                            options = listOf("Website", "Search engine", "Social media", "Email"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Програмне забезпечення (Software)</b><br>\n" +
                                    "- <b>Operating system</b> – операційна система<br>\n" +
                                    "- <b>Application (App)</b> – додаток<br>\n" +
                                    "- <b>Browser</b> – браузер<br>\n" +
                                    "- <b>Antivirus</b> – антивірус<br>\n" +
                                    "- <b>Cloud storage</b> – хмарне сховище<br>\n" +
                                    "- <b>Update</b> – оновлення<br>\n" +
                                    "- <b>Settings</b> – налаштування<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'браузер' англійською?",
                            options = listOf("Antivirus", "Application", "Browser", "Cloud storage"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про технології</b><br>\n" +
                                    "- <b>My laptop is very fast.</b> – Мій ноутбук дуже швидкий.<br>\n" +
                                    "- <b>Do you have Wi-Fi here?</b> – У вас тут є вай-фай?<br>\n" +
                                    "- <b>I need to download this file.</b> – Мені потрібно завантажити цей файл.<br>\n" +
                                    "- <b>Please update your software.</b> – Будь ласка, оновіть своє програмне забезпечення.<br>\n" +
                                    "- <b>The website is not working.</b> – Вебсайт не працює.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Мені потрібно завантажити цей файл' англійською?",
                            options = listOf("I need to upload this file.", "I need to delete this file.", "I need to download this file.", "I need to search for this file."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 19,
                    title = "Розділ 19",
                    topic = "Емоції та почуття",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Емоції та почуття (Emotions and Feelings)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як описувати емоції, почуття та настрій англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Позитивні емоції (Positive Emotions)</b><br>\n" +
                                    "- <b>Happy</b> – щасливий<br>\n" +
                                    "- <b>Excited</b> – збуджений, радісний<br>\n" +
                                    "- <b>Relaxed</b> – розслаблений<br>\n" +
                                    "- <b>Grateful</b> – вдячний<br>\n" +
                                    "- <b>Confident</b> – впевнений<br>\n" +
                                    "- <b>Surprised</b> – здивований<br>\n" +
                                    "- <b>Proud</b> – гордий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'щасливий'?",
                            options = listOf("Sad", "Angry", "Happy", "Worried"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Негативні емоції (Negative Emotions)</b><br>\n" +
                                    "- <b>Sad</b> – сумний<br>\n" +
                                    "- <b>Angry</b> – злий<br>\n" +
                                    "- <b>Nervous</b> – нервовий<br>\n" +
                                    "- <b>Upset</b> – засмучений<br>\n" +
                                    "- <b>Lonely</b> – самотній<br>\n" +
                                    "- <b>Disappointed</b> – розчарований<br>\n" +
                                    "- <b>Scared</b> – наляканий<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'злий' англійською?",
                            options = listOf("Happy", "Scared", "Angry", "Excited"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як описати свій настрій? (Describing Your Mood)</b><br>\n" +
                                    "- <b>I feel great today!</b> – Я почуваюся чудово сьогодні!<br>\n" +
                                    "- <b>She looks very happy.</b> – Вона виглядає дуже щасливою.<br>\n" +
                                    "- <b>He seems nervous before the exam.</b> – Він виглядає нервовим перед іспитом.<br>\n" +
                                    "- <b>I'm a little bit tired.</b> – Я трохи втомлений.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я почуваюся чудово сьогодні' англійською?",
                            options = listOf("I feel tired today.", "I feel great today!", "I look angry today.", "I feel lonely today."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Запитання про емоції (Asking About Feelings)</b><br>\n" +
                                    "- <b>How do you feel today?</b> – Як ти почуваєшся сьогодні?<br>\n" +
                                    "- <b>Are you okay?</b> – Ти в порядку?<br>\n" +
                                    "- <b>What’s wrong?</b> – Що сталося?<br>\n" +
                                    "- <b>You look tired. Do you need a break?</b> – Ти виглядаєш втомленим. Тобі потрібна перерва?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Як ти почуваєшся сьогодні?' англійською?",
                            options = listOf("What’s wrong?", "How do you feel today?", "Are you okay?", "Do you feel sad?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про емоції</b><br>\n" +
                                    "- <b>I'm so excited about the trip!</b> – Я так схвильований через подорож!<br>\n" +
                                    "- <b>She was really disappointed with the results.</b> – Вона була дуже розчарована результатами.<br>\n" +
                                    "- <b>He is scared of spiders.</b> – Він боїться павуків.<br>\n" +
                                    "- <b>They felt proud of their work.</b> – Вони відчували гордість за свою роботу.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Він боїться павуків' англійською?",
                            options = listOf("He loves spiders.", "He is scared of spiders.", "He is happy with spiders.", "He is excited about spiders."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 20,
                    title = "Розділ 20",
                    topic = "Лікарня та здоров’я",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Лікарня та здоров’я (Hospital and Health)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основні слова та фрази, пов'язані зі здоров’ям, лікарями та медичною допомогою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Частини лікарні (Hospital Departments)</b><br>\n" +
                                    "- <b>Emergency room (ER)</b> – відділення невідкладної допомоги<br>\n" +
                                    "- <b>Reception</b> – реєстратура<br>\n" +
                                    "- <b>Waiting room</b> – зал очікування<br>\n" +
                                    "- <b>Operating room</b> – операційна<br>\n" +
                                    "- <b>Pharmacy</b> – аптека<br>\n" +
                                    "- <b>Intensive care unit (ICU)</b> – відділення інтенсивної терапії<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'аптека'?",
                            options = listOf("Hospital", "Reception", "Pharmacy", "ICU"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Медичний персонал (Medical Staff)</b><br>\n" +
                                    "- <b>Doctor</b> – лікар<br>\n" +
                                    "- <b>Nurse</b> – медсестра/медбрат<br>\n" +
                                    "- <b>Surgeon</b> – хірург<br>\n" +
                                    "- <b>Paramedic</b> – фельдшер<br>\n" +
                                    "- <b>Dentist</b> – стоматолог<br>\n" +
                                    "- <b>Therapist</b> – терапевт<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'хірург' англійською?",
                            options = listOf("Dentist", "Therapist", "Surgeon", "Paramedic"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Симптоми та хвороби (Symptoms and Illnesses)</b><br>\n" +
                                    "- <b>Fever</b> – гарячка<br>\n" +
                                    "- <b>Cough</b> – кашель<br>\n" +
                                    "- <b>Runny nose</b> – нежить<br>\n" +
                                    "- <b>Sore throat</b> – біль у горлі<br>\n" +
                                    "- <b>Headache</b> – головний біль<br>\n" +
                                    "- <b>Stomachache</b> – біль у животі<br>\n" +
                                    "- <b>Allergy</b> – алергія<br>\n" +
                                    "- <b>Injury</b> – травма<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'головний біль' англійською?",
                            options = listOf("Fever", "Cough", "Headache", "Sore throat"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Ліки та лікування (Medicine and Treatment)</b><br>\n" +
                                    "- <b>Pill</b> – пігулка<br>\n" +
                                    "- <b>Antibiotics</b> – антибіотики<br>\n" +
                                    "- <b>Painkiller</b> – знеболююче<br>\n" +
                                    "- <b>Syrup</b> – сироп від кашлю<br>\n" +
                                    "- <b>Bandage</b> – бинт<br>\n" +
                                    "- <b>Vaccine</b> – вакцина<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'знеболююче' англійською?",
                            options = listOf("Pill", "Painkiller", "Antibiotics", "Syrup"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази у лікарні (Useful Phrases in a Hospital)</b><br>\n" +
                                    "- <b>I don’t feel well.</b> – Я почуваюся погано.<br>\n" +
                                    "- <b>Do you have a fever?</b> – У тебе гарячка?<br>\n" +
                                    "- <b>Where is the nearest pharmacy?</b> – Де знаходиться найближча аптека?<br>\n" +
                                    "- <b>I need to see a doctor.</b> – Мені потрібно до лікаря.<br>\n" +
                                    "- <b>Take this pill twice a day.</b> – Приймайте цю пігулку двічі на день.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я почуваюся погано' англійською?",
                            options = listOf("I feel great.", "I don’t feel well.", "I am very tired.", "I have an injury."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 21,
                    title = "Розділ 21",
                    topic = "Дозвілля: кіно, музика, відпочинок",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Дозвілля: кіно, музика, відпочинок (Leisure: Movies, Music, Relaxation)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основну лексику, пов'язану з розвагами, кіно, музикою та відпочинком.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Жанри фільмів (Movie Genres)</b><br>\n" +
                                    "- <b>Action</b> – бойовик<br>\n" +
                                    "- <b>Comedy</b> – комедія<br>\n" +
                                    "- <b>Drama</b> – драма<br>\n" +
                                    "- <b>Horror</b> – жахи<br>\n" +
                                    "- <b>Science fiction (Sci-Fi)</b> – наукова фантастика<br>\n" +
                                    "- <b>Romance</b> – романтичний фільм<br>\n" +
                                    "- <b>Documentary</b> – документальний фільм<br>\n" +
                                    "- <b>Animation</b> – анімація (мультфільм)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'комедія'?",
                            options = listOf("Drama", "Horror", "Comedy", "Action"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як говорити про фільми? (Talking About Movies)</b><br>\n" +
                                    "- <b>What’s your favorite movie?</b> – Який твій улюблений фільм?<br>\n" +
                                    "- <b>I love action movies.</b> – Я люблю бойовики.<br>\n" +
                                    "- <b>This movie was very interesting.</b> – Цей фільм був дуже цікавим.<br>\n" +
                                    "- <b>The ending was unexpected.</b> – Кінець був несподіваним.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Який твій улюблений фільм?' англійською?",
                            options = listOf("What’s your favorite movie?", "What is this movie?", "Do you like movies?", "Where is the cinema?"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Музичні жанри (Music Genres)</b><br>\n" +
                                    "- <b>Pop</b> – поп-музика<br>\n" +
                                    "- <b>Rock</b> – рок<br>\n" +
                                    "- <b>Classical</b> – класична музика<br>\n" +
                                    "- <b>Jazz</b> – джаз<br>\n" +
                                    "- <b>Hip-hop</b> – хіп-хоп<br>\n" +
                                    "- <b>Electronic</b> – електронна музика<br>\n" +
                                    "- <b>Country</b> – кантрі<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'рок'?",
                            options = listOf("Jazz", "Rock", "Pop", "Country"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як говорити про музику? (Talking About Music)</b><br>\n" +
                                    "- <b>What kind of music do you like?</b> – Яку музику ти любиш?<br>\n" +
                                    "- <b>I enjoy listening to jazz.</b> – Мені подобається слухати джаз.<br>\n" +
                                    "- <b>Do you play any musical instruments?</b> – Ти граєш на якомусь музичному інструменті?<br>\n" +
                                    "- <b>My favorite band is Coldplay.</b> – Моя улюблена група – Coldplay.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Моя улюблена група – Coldplay' англійською?",
                            options = listOf("I love music.", "My favorite band is Coldplay.", "I play in a band.", "This is my song."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Відпочинок і дозвілля (Relaxation and Leisure Activities)</b><br>\n" +
                                    "- <b>Go to the cinema</b> – ходити в кінотеатр<br>\n" +
                                    "- <b>Read a book</b> – читати книгу<br>\n" +
                                    "- <b>Go for a walk</b> – піти на прогулянку<br>\n" +
                                    "- <b>Listen to music</b> – слухати музику<br>\n" +
                                    "- <b>Watch TV</b> – дивитися телевізор<br>\n" +
                                    "- <b>Do yoga</b> – займатися йогою<br>\n" +
                                    "- <b>Go to a concert</b> – ходити на концерт<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Ходити в кінотеатр' англійською?",
                            options = listOf("Watch TV", "Listen to music", "Go to the cinema", "Go for a walk"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>6. Корисні фрази про дозвілля</b><br>\n" +
                                    "- <b>Let’s go to the cinema this weekend!</b> – Давай підемо в кіно цього вікенду!<br>\n" +
                                    "- <b>What do you like to do in your free time?</b> – Чим ти любиш займатися у вільний час?<br>\n" +
                                    "- <b>I usually relax by reading books.</b> – Я зазвичай відпочиваю, читаючи книги.<br>\n" +
                                    "- <b>That concert was amazing!</b> – Цей концерт був неймовірним!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Давай підемо в кіно цього вікенду!' англійською?",
                            options = listOf("Let’s watch TV tonight.", "Let’s go to the cinema this weekend!", "Do you like watching movies?", "Where is the cinema?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 22,
                    title = "Розділ 22",
                    topic = "Основні фрази в повсякденному житті",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Основні фрази в повсякденному житті (Essential Phrases in Daily Life)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основні фрази, які використовуються в повсякденному спілкуванні англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Вітання та прощання (Greetings and Farewells)</b><br>\n" +
                                    "- <b>Hello</b> – Привіт<br>\n" +
                                    "- <b>Hi</b> – Привіт (неформально)<br>\n" +
                                    "- <b>Good morning</b> – Доброго ранку<br>\n" +
                                    "- <b>Good afternoon</b> – Добрий день<br>\n" +
                                    "- <b>Good evening</b> – Добрий вечір<br>\n" +
                                    "- <b>Goodbye</b> – До побачення<br>\n" +
                                    "- <b>See you later</b> – Побачимося пізніше<br>\n" +
                                    "- <b>Take care</b> – Бережи себе<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Доброго ранку' англійською?",
                            options = listOf("Good evening", "Good morning", "Goodbye", "See you later"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Прохання та подяка (Requests and Thanks)</b><br>\n" +
                                    "- <b>Please</b> – Будь ласка<br>\n" +
                                    "- <b>Thank you</b> – Дякую<br>\n" +
                                    "- <b>You’re welcome</b> – Будь ласка (у відповідь на подяку)<br>\n" +
                                    "- <b>Excuse me</b> – Вибачте (щоб привернути увагу)<br>\n" +
                                    "- <b>Sorry</b> – Вибачте (за провину)<br>\n" +
                                    "- <b>No problem</b> – Без проблем<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Дякую' англійською?",
                            options = listOf("Please", "Excuse me", "Sorry", "Thank you"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>3. Спілкування у магазині (Shopping Phrases)</b><br>\n" +
                                    "- <b>How much does it cost?</b> – Скільки це коштує?<br>\n" +
                                    "- <b>Do you have this in another size?</b> – У вас є це в іншому розмірі?<br>\n" +
                                    "- <b>Where can I find the checkout?</b> – Де я можу знайти касу?<br>\n" +
                                    "- <b>Can I pay by card?</b> – Чи можу я розрахуватися карткою?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Скільки це коштує?' англійською?",
                            options = listOf("How much does it cost?", "Can I pay by card?", "Do you have this in blue?", "Is it expensive?"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Запитання про напрямки (Asking for Directions)</b><br>\n" +
                                    "- <b>Where is the nearest bus stop?</b> – Де знаходиться найближча автобусна зупинка?<br>\n" +
                                    "- <b>How do I get to the train station?</b> – Як дістатися до залізничної станції?<br>\n" +
                                    "- <b>Turn left.</b> – Поверніть ліворуч.<br>\n" +
                                    "- <b>Turn right.</b> – Поверніть праворуч.<br>\n" +
                                    "- <b>Go straight ahead.</b> – Йдіть прямо.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Поверніть праворуч' англійською?",
                            options = listOf("Go straight ahead", "Turn left", "Turn right", "Stop here"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Спілкування в кафе чи ресторані (Restaurant Phrases)</b><br>\n" +
                                    "- <b>I’d like a coffee, please.</b> – Я б хотів каву, будь ласка.<br>\n" +
                                    "- <b>Can I see the menu?</b> – Можна подивитися меню?<br>\n" +
                                    "- <b>What do you recommend?</b> – Що ви порадите?<br>\n" +
                                    "- <b>Can I have the bill, please?</b> – Можна рахунок, будь ласка?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Можна рахунок, будь ласка?' англійською?",
                            options = listOf("Can I see the menu?", "Can I have the bill, please?", "What do you recommend?", "I’d like a coffee, please."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>6. Корисні фрази у повсякденному житті</b><br>\n" +
                                    "- <b>What’s your name?</b> – Як тебе звати?<br>\n" +
                                    "- <b>Where are you from?</b> – Звідки ти?<br>\n" +
                                    "- <b>How old are you?</b> – Скільки тобі років?<br>\n" +
                                    "- <b>Nice to meet you!</b> – Приємно познайомитися!<br>\n" +
                                    "- <b>Have a nice day!</b> – Гарного дня!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Гарного дня!' англійською?",
                            options = listOf("Good morning!", "Goodbye!", "See you later!", "Have a nice day!"),
                            correctAnswerIndex = 3
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_vocabulary_a1
        ),
        Course(
            id = 4,
            title = "Лексика",
            level = "Англійська рівень А2",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Спілкування та соціальні вирази",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Спілкування та соціальні вирази (Communication and Social Expressions)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як ввічливо спілкуватися, підтримувати розмову та відповідати на запитання в різних ситуаціях.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Початок розмови (Starting a Conversation)</b><br>\n" +
                                    "- <b>Excuse me, do you have a moment?</b> – Вибачте, у вас є хвилинка?<br>\n" +
                                    "- <b>Can I ask you something?</b> – Чи можу я вас щось запитати?<br>\n" +
                                    "- <b>How are you doing?</b> – Як у вас справи?<br>\n" +
                                    "- <b>What have you been up to?</b> – Чим ви займалися останнім часом?<br>\n" +
                                    "- <b>It’s nice to see you again!</b> – Приємно вас знову бачити!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чим ви займалися останнім часом?' англійською?",
                            options = listOf("How are you doing?", "What have you been up to?", "Can I ask you something?", "It’s nice to see you again!"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Ввічливі фрази (Polite Expressions)</b><br>\n" +
                                    "- <b>Would you mind if I…?</b> – Ви не заперечуєте, якщо я…?<br>\n" +
                                    "- <b>Could you please help me?</b> – Чи могли б ви мені допомогти?<br>\n" +
                                    "- <b>That’s very kind of you.</b> – Це дуже люб’язно з вашого боку.<br>\n" +
                                    "- <b>I really appreciate it.</b> – Я це дуже ціную.<br>\n" +
                                    "- <b>I’m sorry for the inconvenience.</b> – Вибачте за незручності.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я це дуже ціную' англійською?",
                            options = listOf("That’s very kind of you.", "I’m sorry for the inconvenience.", "I really appreciate it.", "Could you please help me?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як підтримати розмову? (Keeping a Conversation Going)</b><br>\n" +
                                    "- <b>That sounds interesting!</b> – Це звучить цікаво!<br>\n" +
                                    "- <b>Really? Tell me more.</b> – Справді? Розкажіть більше.<br>\n" +
                                    "- <b>I see what you mean.</b> – Я розумію, що ви маєте на увазі.<br>\n" +
                                    "- <b>By the way…</b> – До речі…<br>\n" +
                                    "- <b>Speaking of that…</b> – Говорячи про це…<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Це звучить цікаво!' англійською?",
                            options = listOf("Really? Tell me more.", "That sounds interesting!", "Speaking of that…", "I see what you mean."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як погоджуватися або не погоджуватися (Agreeing and Disagreeing)</b><br>\n" +
                                    "- <b>I completely agree with you.</b> – Я повністю з вами згоден.<br>\n" +
                                    "- <b>That’s true.</b> – Це правда.<br>\n" +
                                    "- <b>I see your point, but…</b> – Я розумію вашу точку зору, але…<br>\n" +
                                    "- <b>I’m not sure about that.</b> – Я не впевнений щодо цього.<br>\n" +
                                    "- <b>I don’t think so.</b> – Я так не думаю.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я повністю з вами згоден' англійською?",
                            options = listOf("I completely agree with you.", "I’m not sure about that.", "That’s true.", "I don’t think so."),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Завершення розмови (Ending a Conversation)</b><br>\n" +
                                    "- <b>It was great talking to you!</b> – Було приємно з вами поговорити!<br>\n" +
                                    "- <b>I have to go now.</b> – Мені треба йти.<br>\n" +
                                    "- <b>See you soon!</b> – Побачимося скоро!<br>\n" +
                                    "- <b>Take care!</b> – Бережи себе!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Було приємно з вами поговорити!' англійською?",
                            options = listOf("See you soon!", "It was great talking to you!", "I have to go now.", "Take care!"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Повсякденні справи та розпорядок дня",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Повсякденні справи та розпорядок дня (Daily Activities and Routine)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як описувати свій щоденний розпорядок та основні дії, які виконуються протягом дня.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Ранкові звички (Morning Routine)</b><br>\n" +
                                    "- <b>Wake up</b> – прокидатися<br>\n" +
                                    "- <b>Get up</b> – вставати з ліжка<br>\n" +
                                    "- <b>Take a shower</b> – приймати душ<br>\n" +
                                    "- <b>Brush my teeth</b> – чистити зуби<br>\n" +
                                    "- <b>Get dressed</b> – одягатися<br>\n" +
                                    "- <b>Have breakfast</b> – снідати<br>\n" +
                                    "- <b>Go to work/school</b> – йти на роботу/до школи<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'чистити зуби'?",
                            options = listOf("Wake up", "Get up", "Brush my teeth", "Take a shower"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Дії протягом дня (Activities During the Day)</b><br>\n" +
                                    "- <b>Have lunch</b> – обідати<br>\n" +
                                    "- <b>Work/study</b> – працювати/навчатися<br>\n" +
                                    "- <b>Take a break</b> – робити перерву<br>\n" +
                                    "- <b>Go shopping</b> – ходити за покупками<br>\n" +
                                    "- <b>Check emails</b> – перевіряти електронну пошту<br>\n" +
                                    "- <b>Make phone calls</b> – телефонувати<br>\n" +
                                    "- <b>Meet friends</b> – зустрічатися з друзями<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'робити перерву' англійською?",
                            options = listOf("Take a break", "Have lunch", "Check emails", "Go shopping"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Вечірні звички (Evening Routine)</b><br>\n" +
                                    "- <b>Come home</b> – повертатися додому<br>\n" +
                                    "- <b>Have dinner</b> – вечеряти<br>\n" +
                                    "- <b>Watch TV</b> – дивитися телевізор<br>\n" +
                                    "- <b>Read a book</b> – читати книгу<br>\n" +
                                    "- <b>Take a bath</b> – приймати ванну<br>\n" +
                                    "- <b>Go to bed</b> – лягати спати<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'повертатися додому' англійською?",
                            options = listOf("Go to bed", "Come home", "Read a book", "Take a bath"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як розповісти про свій день? (Talking About Your Day)</b><br>\n" +
                                    "- <b>I wake up at 7 AM.</b> – Я прокидаюся о 7 ранку.<br>\n" +
                                    "- <b>After breakfast, I go to work.</b> – Після сніданку я йду на роботу.<br>\n" +
                                    "- <b>In the evening, I like to relax.</b> – Ввечері я люблю відпочивати.<br>\n" +
                                    "- <b>Before going to bed, I read a book.</b> – Перед сном я читаю книгу.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я прокидаюся о 7 ранку' англійською?",
                            options = listOf("I have breakfast at 7 AM.", "I wake up at 7 AM.", "I go to work at 7 AM.", "I take a shower at 7 AM."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази для розмови про повсякденні справи</b><br>\n" +
                                    "- <b>What time do you wake up?</b> – О котрій ти прокидаєшся?<br>\n" +
                                    "- <b>How do you usually spend your day?</b> – Як ти зазвичай проводиш свій день?<br>\n" +
                                    "- <b>Do you have a busy schedule?</b> – У тебе напружений графік?<br>\n" +
                                    "- <b>On weekends, I like to sleep in.</b> – На вихідних я люблю довше поспати.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Як ти зазвичай проводиш свій день?' англійською?",
                            options = listOf("What time do you wake up?", "Do you have a busy schedule?", "How do you usually spend your day?", "On weekends, I like to sleep in."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Покупки та споживчі товари",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Покупки та споживчі товари (Shopping and Consumer Goods)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як говорити про покупки, товари та взаємодію з продавцями англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види магазинів (Types of Shops)</b><br>\n" +
                                    "- <b>Supermarket</b> – супермаркет<br>\n" +
                                    "- <b>Grocery store</b> – продуктовий магазин<br>\n" +
                                    "- <b>Clothing store</b> – магазин одягу<br>\n" +
                                    "- <b>Shoe shop</b> – магазин взуття<br>\n" +
                                    "- <b>Electronics store</b> – магазин електроніки<br>\n" +
                                    "- <b>Pharmacy</b> – аптека<br>\n" +
                                    "- <b>Bookstore</b> – книжковий магазин<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'магазин електроніки' англійською?",
                            options = listOf("Supermarket", "Electronics store", "Shoe shop", "Bookstore"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Покупки продуктів (Grocery Shopping)</b><br>\n" +
                                    "- <b>Vegetables</b> – овочі<br>\n" +
                                    "- <b>Fruits</b> – фрукти<br>\n" +
                                    "- <b>Meat</b> – м’ясо<br>\n" +
                                    "- <b>Dairy products</b> – молочні продукти<br>\n" +
                                    "- <b>Bakery</b> – хлібобулочні вироби<br>\n" +
                                    "- <b>Beverages</b> – напої<br>\n" +
                                    "- <b>Frozen food</b> – заморожені продукти<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'молочні продукти' англійською?",
                            options = listOf("Bakery", "Dairy products", "Meat", "Frozen food"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як запитати про товар? (Asking About a Product)</b><br>\n" +
                                    "- <b>Do you have this in a different size?</b> – У вас є це в іншому розмірі?<br>\n" +
                                    "- <b>What material is this made of?</b> – З якого матеріалу це зроблено?<br>\n" +
                                    "- <b>Is this on sale?</b> – Чи є це в розпродажі?<br>\n" +
                                    "- <b>Can I try it on?</b> – Чи можу я це приміряти?<br>\n" +
                                    "- <b>Do you have a discount?</b> – У вас є знижка?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чи можу я це приміряти?' англійською?",
                            options = listOf("Can I buy it?", "Do you have a discount?", "Can I try it on?", "Is this on sale?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Оплата товарів (Paying for Goods)</b><br>\n" +
                                    "- <b>How much does it cost?</b> – Скільки це коштує?<br>\n" +
                                    "- <b>Can I pay by card?</b> – Чи можу я розрахуватися карткою?<br>\n" +
                                    "- <b>Do you accept cash?</b> – Ви приймаєте готівку?<br>\n" +
                                    "- <b>Here’s your change.</b> – Ось ваша решта.<br>\n" +
                                    "- <b>Can I get a receipt?</b> – Можна мені чек?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Чи можу я розрахуватися карткою?' англійською?",
                            options = listOf("How much does it cost?", "Do you accept cash?", "Can I pay by card?", "Can I get a receipt?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Повернення товару та скарги (Returns and Complaints)</b><br>\n" +
                                    "- <b>I’d like to return this item.</b> – Я б хотів повернути цей товар.<br>\n" +
                                    "- <b>This item is damaged.</b> – Цей товар пошкоджений.<br>\n" +
                                    "- <b>Can I exchange this for a different size?</b> – Чи можу я обміняти це на інший розмір?<br>\n" +
                                    "- <b>I need a refund.</b> – Мені потрібне повернення коштів.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я б хотів повернути цей товар' англійською?",
                            options = listOf("Can I get a refund?", "I’d like to return this item.", "Can I exchange this?", "This item is damaged."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Гроші та фінанси",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Гроші та фінанси (Money and Finance)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основну лексику, пов'язану з грошима, банками, оплатою та фінансовими операціями.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основна фінансова лексика (Basic Financial Vocabulary)</b><br>\n" +
                                    "- <b>Money</b> – гроші<br>\n" +
                                    "- <b>Cash</b> – готівка<br>\n" +
                                    "- <b>Credit card</b> – кредитна картка<br>\n" +
                                    "- <b>Debit card</b> – дебетова картка<br>\n" +
                                    "- <b>Coins</b> – монети<br>\n" +
                                    "- <b>Banknotes</b> – банкноти<br>\n" +
                                    "- <b>Wallet</b> – гаманець<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'гаманець'?",
                            options = listOf("Banknotes", "Wallet", "Cash", "Credit card"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Банківські операції (Banking Transactions)</b><br>\n" +
                                    "- <b>Bank account</b> – банківський рахунок<br>\n" +
                                    "- <b>Deposit</b> – депозит, внесок<br>\n" +
                                    "- <b>Withdrawal</b> – зняття грошей<br>\n" +
                                    "- <b>Transfer</b> – переказ<br>\n" +
                                    "- <b>Loan</b> – кредит, позика<br>\n" +
                                    "- <b>Interest rate</b> – відсоткова ставка<br>\n" +
                                    "- <b>ATM (cash machine)</b> – банкомат<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'банківський рахунок' англійською?",
                            options = listOf("Deposit", "Transfer", "Bank account", "ATM"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Оплата товарів та послуг (Paying for Goods and Services)</b><br>\n" +
                                    "- <b>How much does it cost?</b> – Скільки це коштує?<br>\n" +
                                    "- <b>Can I pay by card?</b> – Чи можу я розрахуватися карткою?<br>\n" +
                                    "- <b>Do you accept cash?</b> – Ви приймаєте готівку?<br>\n" +
                                    "- <b>Here’s your change.</b> – Ось ваша решта.<br>\n" +
                                    "- <b>Can I get a receipt?</b> – Можна мені чек?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Скільки це коштує?' англійською?",
                            options = listOf("Do you accept cash?", "Can I get a receipt?", "How much does it cost?", "Can I pay by card?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Фінансове планування (Financial Planning)</b><br>\n" +
                                    "- <b>Budget</b> – бюджет<br>\n" +
                                    "- <b>Expenses</b> – витрати<br>\n" +
                                    "- <b>Income</b> – дохід<br>\n" +
                                    "- <b>Saving money</b> – заощадження грошей<br>\n" +
                                    "- <b>Investment</b> – інвестиція<br>\n" +
                                    "- <b>Debt</b> – борг<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'витрати' англійською?",
                            options = listOf("Debt", "Income", "Expenses", "Investment"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази у сфері фінансів</b><br>\n" +
                                    "- <b>I need to withdraw some cash.</b> – Мені потрібно зняти готівку.<br>\n" +
                                    "- <b>Can you give me a receipt?</b> – Ви можете дати мені чек?<br>\n" +
                                    "- <b>I want to exchange money.</b> – Я хочу обміняти гроші.<br>\n" +
                                    "- <b>How much is the interest rate?</b> – Яка відсоткова ставка?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Мені потрібно зняти готівку' англійською?",
                            options = listOf("I want to exchange money.", "How much is the interest rate?", "I need to withdraw some cash.", "Can you give me a receipt?"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Їжа та кулінарія: приготування їжі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Їжа та кулінарія: приготування їжі (Food and Cooking: Preparing Meals)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь основну лексику, пов'язану з приготуванням їжі, інгредієнтами та кулінарними процесами.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні інгредієнти (Basic Ingredients)</b><br>\n" +
                                    "- <b>Flour</b> – борошно<br>\n" +
                                    "- <b>Sugar</b> – цукор<br>\n" +
                                    "- <b>Salt</b> – сіль<br>\n" +
                                    "- <b>Eggs</b> – яйця<br>\n" +
                                    "- <b>Butter</b> – масло<br>\n" +
                                    "- <b>Milk</b> – молоко<br>\n" +
                                    "- <b>Vegetable oil</b> – рослинна олія<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'борошно' англійською?",
                            options = listOf("Sugar", "Flour", "Butter", "Eggs"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Способи приготування їжі (Cooking Methods)</b><br>\n" +
                                    "- <b>Boil</b> – варити<br>\n" +
                                    "- <b>Fry</b> – смажити<br>\n" +
                                    "- <b>Grill</b> – готувати на грилі<br>\n" +
                                    "- <b>Bake</b> – випікати<br>\n" +
                                    "- <b>Steam</b> – готувати на пару<br>\n" +
                                    "- <b>Roast</b> – запікати (в духовці)<br>\n" +
                                    "- <b>Mix</b> – змішувати<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'смажити' англійською?",
                            options = listOf("Boil", "Grill", "Fry", "Bake"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Кухонне приладдя (Kitchen Utensils)</b><br>\n" +
                                    "- <b>Knife</b> – ніж<br>\n" +
                                    "- <b>Cutting board</b> – дошка для нарізання<br>\n" +
                                    "- <b>Pan</b> – сковорідка<br>\n" +
                                    "- <b>Pot</b> – каструля<br>\n" +
                                    "- <b>Oven</b> – духовка<br>\n" +
                                    "- <b>Blender</b> – блендер<br>\n" +
                                    "- <b>Whisk</b> – вінчик<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'духовка' англійською?",
                            options = listOf("Pan", "Pot", "Blender", "Oven"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як описати процес приготування? (Describing the Cooking Process)</b><br>\n" +
                                    "- <b>First, chop the onions.</b> – Спочатку наріжте цибулю.<br>\n" +
                                    "- <b>Then, add some salt and pepper.</b> – Потім додайте трохи солі та перцю.<br>\n" +
                                    "- <b>After that, mix all the ingredients.</b> – Після цього змішайте всі інгредієнти.<br>\n" +
                                    "- <b>Finally, bake it for 30 minutes.</b> – Нарешті, випікайте це протягом 30 хвилин.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Спочатку наріжте цибулю' англійською?",
                            options = listOf("Then, add some salt and pepper.", "After that, mix all the ingredients.", "First, chop the onions.", "Finally, bake it for 30 minutes."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази у кулінарії (Useful Cooking Phrases)</b><br>\n" +
                                    "- <b>Can you pass me the salt?</b> – Можеш передати мені сіль?<br>\n" +
                                    "- <b>How long should I cook this?</b> – Як довго це потрібно готувати?<br>\n" +
                                    "- <b>What ingredients do we need?</b> – Які інгредієнти нам потрібні?<br>\n" +
                                    "- <b>It smells delicious!</b> – Це пахне смачно!<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Це пахне смачно!' англійською?",
                            options = listOf("Can you pass me the salt?", "It smells delicious!", "How long should I cook this?", "What ingredients do we need?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Заклади харчування: ресторан, кафе, замовлення їжі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Заклади харчування: ресторан, кафе, замовлення їжі (Dining Out: Restaurant, Café, Ordering Food)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як зробити замовлення в ресторані чи кафе, спілкуватися з офіціантом та запитувати про меню.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види закладів харчування (Types of Dining Places)</b><br>\n" +
                                    "- <b>Restaurant</b> – ресторан<br>\n" +
                                    "- <b>Café</b> – кафе<br>\n" +
                                    "- <b>Fast food restaurant</b> – заклад швидкого харчування<br>\n" +
                                    "- <b>Buffet</b> – шведський стіл<br>\n" +
                                    "- <b>Food truck</b> – фуд-трак<br>\n" +
                                    "- <b>Bistro</b> – бістро<br>\n" +
                                    "- <b>Pub</b> – паб<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як англійською буде 'ресторан'?",
                            options = listOf("Café", "Bistro", "Restaurant", "Pub"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Частини меню (Parts of a Menu)</b><br>\n" +
                                    "- <b>Appetizers (Starters)</b> – закуски<br>\n" +
                                    "- <b>Main course</b> – основна страва<br>\n" +
                                    "- <b>Side dish</b> – гарнір<br>\n" +
                                    "- <b>Dessert</b> – десерт<br>\n" +
                                    "- <b>Beverages</b> – напої<br>\n" +
                                    "- <b>Specials</b> – спеціальні пропозиції (страви дня)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'десерт' англійською?",
                            options = listOf("Side dish", "Beverages", "Appetizers", "Dessert"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як зробити замовлення? (Ordering Food)</b><br>\n" +
                                    "- <b>Can I see the menu, please?</b> – Можна мені меню, будь ласка?<br>\n" +
                                    "- <b>What do you recommend?</b> – Що ви порадите?<br>\n" +
                                    "- <b>I’d like a steak, please.</b> – Я б хотів стейк, будь ласка.<br>\n" +
                                    "- <b>Can I have a glass of water?</b> – Можна мені склянку води?<br>\n" +
                                    "- <b>Is this dish spicy?</b> – Ця страва гостра?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Що ви порадите?' англійською?",
                            options = listOf("Is this dish spicy?", "What do you recommend?", "Can I have the bill?", "Can I see the menu?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як запитати про оплату? (Paying the Bill)</b><br>\n" +
                                    "- <b>Can I have the bill, please?</b> – Можна рахунок, будь ласка?<br>\n" +
                                    "- <b>Do you accept credit cards?</b> – Ви приймаєте кредитні картки?<br>\n" +
                                    "- <b>Is service included?</b> – Чи включено обслуговування у вартість?<br>\n" +
                                    "- <b>Can we split the bill?</b> – Чи можемо ми розділити рахунок?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Можна рахунок, будь ласка?' англійською?",
                            options = listOf("Can I see the menu?", "Can I have the bill, please?", "What do you recommend?", "Do you accept credit cards?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Замовлення їжі з доставкою (Ordering Takeout or Delivery)</b><br>\n" +
                                    "- <b>I’d like to order some food for delivery.</b> – Я б хотів замовити їжу з доставкою.<br>\n" +
                                    "- <b>Can I pick up my order?</b> – Чи можу я забрати своє замовлення?<br>\n" +
                                    "- <b>How long will it take?</b> – Скільки часу це займе?<br>\n" +
                                    "- <b>Can I pay online?</b> – Чи можу я оплатити онлайн?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Скільки часу це займе?' англійською?",
                            options = listOf("Can I pick up my order?", "Can I pay online?", "How long will it take?", "What do you recommend?"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Подорожі та бронювання житла",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Подорожі та бронювання житла (Travel and Accommodation Booking)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь, як бронювати житло, купувати квитки, питати дорогу та спілкуватися під час подорожей.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види транспорту (Types of Transportation)</b><br>\n" +
                                    "- <b>Plane</b> – літак<br>\n" +
                                    "- <b>Train</b> – потяг<br>\n" +
                                    "- <b>Bus</b> – автобус<br>\n" +
                                    "- <b>Taxi</b> – таксі<br>\n" +
                                    "- <b>Car rental</b> – оренда автомобіля<br>\n" +
                                    "- <b>Subway (Metro)</b> – метро<br>\n" +
                                    "- <b>Boat</b> – човен, корабель<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'літак' англійською?",
                            options = listOf("Train", "Boat", "Taxi", "Plane"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>2. Як забронювати квиток? (Booking a Ticket)</b><br>\n" +
                                    "- <b>I’d like to book a flight to London.</b> – Я хочу забронювати рейс до Лондона.<br>\n" +
                                    "- <b>How much is a train ticket to Paris?</b> – Скільки коштує квиток на потяг до Парижа?<br>\n" +
                                    "- <b>Is this a direct flight?</b> – Це прямий рейс?<br>\n" +
                                    "- <b>What time does the bus leave?</b> – О котрій відправляється автобус?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Скільки коштує квиток на потяг до Парижа?' англійською?",
                            options = listOf("Is this a direct flight?", "How much is a train ticket to Paris?", "What time does the bus leave?", "I’d like to book a flight to London."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Бронювання житла (Booking Accommodation)</b><br>\n" +
                                    "- <b>I’d like to book a hotel room.</b> – Я хочу забронювати номер у готелі.<br>\n" +
                                    "- <b>Do you have any available rooms?</b> – У вас є вільні номери?<br>\n" +
                                    "- <b>How much is a single/double room per night?</b> – Скільки коштує одномісний/двомісний номер за ніч?<br>\n" +
                                    "- <b>Is breakfast included?</b> – Чи включено сніданок?<br>\n" +
                                    "- <b>Can I check in early?</b> – Чи можу я заселитися раніше?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Чи включено сніданок?' англійською?",
                            options = listOf("Do you have any available rooms?", "Can I check in early?", "Is breakfast included?", "How much is a single room per night?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Запитання про послуги у готелі (Asking About Hotel Services)</b><br>\n" +
                                    "- <b>Where is the reception?</b> – Де знаходиться рецепція?<br>\n" +
                                    "- <b>Do you have free Wi-Fi?</b> – У вас є безкоштовний Wi-Fi?<br>\n" +
                                    "- <b>Can I get an extra towel?</b> – Чи можу я отримати додатковий рушник?<br>\n" +
                                    "- <b>What time is breakfast served?</b> – О котрій подають сніданок?<br>\n" +
                                    "- <b>Can I extend my stay?</b> – Чи можу я продовжити своє перебування?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'У вас є безкоштовний Wi-Fi?' англійською?",
                            options = listOf("Where is the reception?", "Can I get an extra towel?", "Do you have free Wi-Fi?", "What time is breakfast served?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Запитання про напрямки (Asking for Directions)</b><br>\n" +
                                    "- <b>How do I get to the airport?</b> – Як мені дістатися до аеропорту?<br>\n" +
                                    "- <b>Where is the nearest metro station?</b> – Де знаходиться найближча станція метро?<br>\n" +
                                    "- <b>Can you show me on the map?</b> – Ви можете показати мені на карті?<br>\n" +
                                    "- <b>Is it far from here?</b> – Це далеко звідси?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Це далеко звідси?' англійською?",
                            options = listOf("Can you show me on the map?", "Where is the nearest metro station?", "How do I get to the airport?", "Is it far from here?"),
                            correctAnswerIndex = 3
                        )
                    )
                ),
                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Види транспорту та дорожні знаки",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Види транспорту та дорожні знаки (Types of Transport and Road Signs)</b><br>\n" +
                                    "У цьому розділі ви дізнаєтесь назви різних видів транспорту та основні дорожні знаки англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види транспорту (Types of Transport)</b><br>\n" +
                                    "- <b>Car</b> – автомобіль<br>\n" +
                                    "- <b>Bus</b> – автобус<br>\n" +
                                    "- <b>Train</b> – потяг<br>\n" +
                                    "- <b>Plane</b> – літак<br>\n" +
                                    "- <b>Bicycle</b> – велосипед<br>\n" +
                                    "- <b>Motorcycle</b> – мотоцикл<br>\n" +
                                    "- <b>Taxi</b> – таксі<br>\n" +
                                    "- <b>Tram</b> – трамвай<br>\n" +
                                    "- <b>Subway (Metro)</b> – метро<br>\n" +
                                    "- <b>Ship</b> – корабель<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'потяг' англійською?",
                            options = listOf("Car", "Bus", "Train", "Tram"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Частини транспортного засобу (Parts of a Vehicle)</b><br>\n" +
                                    "- <b>Steering wheel</b> – кермо<br>\n" +
                                    "- <b>Seatbelt</b> – ремінь безпеки<br>\n" +
                                    "- <b>Headlights</b> – фари<br>\n" +
                                    "- <b>Brakes</b> – гальма<br>\n" +
                                    "- <b>Engine</b> – двигун<br>\n" +
                                    "- <b>Tires</b> – шини<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'фари' англійською?",
                            options = listOf("Brakes", "Headlights", "Tires", "Engine"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Основні дорожні знаки (Basic Road Signs)</b><br>\n" +
                                    "- <b>Stop</b> – Стоп<br>\n" +
                                    "- <b>Speed limit</b> – Обмеження швидкості<br>\n" +
                                    "- <b>No parking</b> – Парковка заборонена<br>\n" +
                                    "- <b>One-way street</b> – Вулиця з одностороннім рухом<br>\n" +
                                    "- <b>Pedestrian crossing</b> – Пішохідний перехід<br>\n" +
                                    "- <b>Traffic lights</b> – Світлофор<br>\n" +
                                    "- <b>Roundabout</b> – Кільцева розв’язка<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Пішохідний перехід' англійською?",
                            options = listOf("Traffic lights", "Roundabout", "Pedestrian crossing", "Speed limit"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як запитати про транспорт? (Asking About Transport)</b><br>\n" +
                                    "- <b>Where is the nearest bus stop?</b> – Де знаходиться найближча автобусна зупинка?<br>\n" +
                                    "- <b>How do I get to the train station?</b> – Як дістатися до залізничної станції?<br>\n" +
                                    "- <b>What time does the subway close?</b> – О котрій закривається метро?<br>\n" +
                                    "- <b>How much is a taxi to the airport?</b> – Скільки коштує таксі до аеропорту?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Як дістатися до залізничної станції?' англійською?",
                            options = listOf("Where is the nearest bus stop?", "How do I get to the train station?", "What time does the subway close?", "How much is a taxi to the airport?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази для транспорту (Useful Transport Phrases)</b><br>\n" +
                                    "- <b>Excuse me, where is the taxi stand?</b> – Вибачте, де стоянка таксі?<br>\n" +
                                    "- <b>Does this bus go to the city center?</b> – Цей автобус їде до центру міста?<br>\n" +
                                    "- <b>Can I buy a ticket here?</b> – Чи можу я купити квиток тут?<br>\n" +
                                    "- <b>What platform does the train leave from?</b> – З якої платформи відправляється потяг?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Цей автобус їде до центру міста?' англійською?",
                            options = listOf("Can I buy a ticket here?", "What platform does the train leave from?", "Does this bus go to the city center?", "Where is the taxi stand?"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Опис місцевості та орієнтація в місті",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Опис місцевості та орієнтація в місті (Describing Places and City Navigation)</b><br>\n" +
                                    "У цьому розділі ви навчитеся описувати місцевість, називати важливі місця у місті та запитувати про напрямки.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні місця у місті (Key Places in a City)</b><br>\n" +
                                    "- <b>City center</b> – центр міста<br>\n" +
                                    "- <b>Park</b> – парк<br>\n" +
                                    "- <b>Museum</b> – музей<br>\n" +
                                    "- <b>Library</b> – бібліотека<br>\n" +
                                    "- <b>Post office</b> – пошта<br>\n" +
                                    "- <b>Hospital</b> – лікарня<br>\n" +
                                    "- <b>Shopping mall</b> – торговий центр<br>\n" +
                                    "- <b>Restaurant</b> – ресторан<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'центр міста' англійською?",
                            options = listOf("Park", "Shopping mall", "City center", "Post office"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Запитання про напрямки (Asking for Directions)</b><br>\n" +
                                    "- <b>Where is the nearest pharmacy?</b> – Де знаходиться найближча аптека?<br>\n" +
                                    "- <b>How do I get to the bus station?</b> – Як дістатися до автовокзалу?<br>\n" +
                                    "- <b>Is it far from here?</b> – Це далеко звідси?<br>\n" +
                                    "- <b>Can you show me on the map?</b> – Чи можете ви показати мені на карті?<br>\n" +
                                    "- <b>Turn left at the next street.</b> – Поверніть ліворуч на наступній вулиці.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Це далеко звідси?' англійською?",
                            options = listOf("Is it far from here?", "Where is the nearest pharmacy?", "Can you show me on the map?", "How do I get to the bus station?"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>3. Орієнтація у місті (City Navigation)</b><br>\n" +
                                    "- <b>Main road</b> – головна дорога<br>\n" +
                                    "- <b>Side street</b> – бічна вулиця<br>\n" +
                                    "- <b>Traffic lights</b> – світлофор<br>\n" +
                                    "- <b>Crosswalk</b> – пішохідний перехід<br>\n" +
                                    "- <b>Intersection</b> – перехрестя<br>\n" +
                                    "- <b>Bridge</b> – міст<br>\n" +
                                    "- <b>Roundabout</b> – кільцева розв’язка<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'перехрестя' англійською?",
                            options = listOf("Intersection", "Roundabout", "Crosswalk", "Side street"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як описати місцевість? (Describing a Place)</b><br>\n" +
                                    "- <b>This area is very crowded.</b> – Ця місцевість дуже людна.<br>\n" +
                                    "- <b>The park is quiet and peaceful.</b> – Парк тихий і спокійний.<br>\n" +
                                    "- <b>The city has a lot of historical buildings.</b> – У місті багато історичних будівель.<br>\n" +
                                    "- <b>The streets are narrow and old.</b> – Вулиці вузькі й старовинні.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Ця місцевість дуже людна' англійською?",
                            options = listOf("The park is quiet and peaceful.", "This area is very crowded.", "The streets are narrow and old.", "The city has a lot of historical buildings."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази для навігації у місті (Useful Phrases for City Navigation)</b><br>\n" +
                                    "- <b>Excuse me, can you help me?</b> – Вибачте, ви можете мені допомогти?<br>\n" +
                                    "- <b>Is there a metro station nearby?</b> – Чи є поблизу станція метро?<br>\n" +
                                    "- <b>Go straight ahead for two blocks.</b> – Ідіть прямо два квартали.<br>\n" +
                                    "- <b>Take the first right.</b> – Поверніть праворуч на першій вулиці.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чи є поблизу станція метро?' англійською?",
                            options = listOf("Go straight ahead for two blocks.", "Take the first right.", "Is there a metro station nearby?", "Excuse me, can you help me?"),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "Довкілля та екологія",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Довкілля та екологія (Environment and Ecology)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про природу, екологічні проблеми та шляхи їх вирішення англійською мовою.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Елементи природи (Elements of Nature)</b><br>\n" +
                                    "- <b>Forest</b> – ліс<br>\n" +
                                    "- <b>River</b> – річка<br>\n" +
                                    "- <b>Mountain</b> – гора<br>\n" +
                                    "- <b>Ocean</b> – океан<br>\n" +
                                    "- <b>Lake</b> – озеро<br>\n" +
                                    "- <b>Desert</b> – пустеля<br>\n" +
                                    "- <b>Island</b> – острів<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'гора' англійською?",
                            options = listOf("Forest", "Mountain", "River", "Ocean"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Екологічні проблеми (Environmental Issues)</b><br>\n" +
                                    "- <b>Air pollution</b> – забруднення повітря<br>\n" +
                                    "- <b>Water pollution</b> – забруднення води<br>\n" +
                                    "- <b>Deforestation</b> – вирубка лісів<br>\n" +
                                    "- <b>Climate change</b> – зміна клімату<br>\n" +
                                    "- <b>Endangered species</b> – зникаючі види<br>\n" +
                                    "- <b>Global warming</b> – глобальне потепління<br>\n" +
                                    "- <b>Plastic waste</b> – пластикові відходи<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'зміна клімату' англійською?",
                            options = listOf("Air pollution", "Deforestation", "Climate change", "Endangered species"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Шляхи захисту довкілля (Ways to Protect the Environment)</b><br>\n" +
                                    "- <b>Recycle</b> – переробляти відходи<br>\n" +
                                    "- <b>Reduce waste</b> – зменшувати кількість відходів<br>\n" +
                                    "- <b>Use renewable energy</b> – використовувати відновлювану енергію<br>\n" +
                                    "- <b>Save water</b> – заощаджувати воду<br>\n" +
                                    "- <b>Plant trees</b> – саджати дерева<br>\n" +
                                    "- <b>Use eco-friendly products</b> – використовувати екологічно чисті продукти<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'переробляти відходи' англійською?",
                            options = listOf("Recycle", "Reduce waste", "Save water", "Plant trees"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Природні катастрофи (Natural Disasters)</b><br>\n" +
                                    "- <b>Earthquake</b> – землетрус<br>\n" +
                                    "- <b>Flood</b> – повінь<br>\n" +
                                    "- <b>Hurricane</b> – ураган<br>\n" +
                                    "- <b>Drought</b> – посуха<br>\n" +
                                    "- <b>Wildfire</b> – лісова пожежа<br>\n" +
                                    "- <b>Tornado</b> – торнадо<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'повінь' англійською?",
                            options = listOf("Hurricane", "Flood", "Drought", "Wildfire"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про екологію (Useful Environmental Phrases)</b><br>\n" +
                                    "- <b>We should recycle more.</b> – Нам слід більше переробляти відходи.<br>\n" +
                                    "- <b>Global warming is a serious problem.</b> – Глобальне потепління – це серйозна проблема.<br>\n" +
                                    "- <b>Pollution affects our health.</b> – Забруднення впливає на наше здоров’я.<br>\n" +
                                    "- <b>Let's protect the planet together.</b> – Давайте разом захистимо планету.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Глобальне потепління – це серйозна проблема' англійською?",
                            options = listOf("Pollution affects our health.", "We should recycle more.", "Global warming is a serious problem.", "Let's protect the planet together."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Види спорту та спортивні змагання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Види спорту та спортивні змагання (Types of Sports and Sporting Competitions)</b><br>\n" +
                                    "У цьому розділі ви навчитеся називати різні види спорту, говорити про спортивні змагання та основні терміни, пов'язані зі спортом.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Види спорту (Types of Sports)</b><br>\n" +
                                    "- <b>Football (Soccer)</b> – футбол<br>\n" +
                                    "- <b>Basketball</b> – баскетбол<br>\n" +
                                    "- <b>Tennis</b> – теніс<br>\n" +
                                    "- <b>Swimming</b> – плавання<br>\n" +
                                    "- <b>Athletics</b> – легка атлетика<br>\n" +
                                    "- <b>Volleyball</b> – волейбол<br>\n" +
                                    "- <b>Boxing</b> – бокс<br>\n" +
                                    "- <b>Ice hockey</b> – хокей на льоду<br>\n" +
                                    "- <b>Gymnastics</b> – гімнастика<br>\n" +
                                    "- <b>Cycling</b> – велоспорт<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'баскетбол' англійською?",
                            options = listOf("Swimming", "Basketball", "Cycling", "Football"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Спортивне обладнання (Sports Equipment)</b><br>\n" +
                                    "- <b>Ball</b> – м'яч<br>\n" +
                                    "- <b>Racket</b> – ракетка<br>\n" +
                                    "- <b>Helmet</b> – шолом<br>\n" +
                                    "- <b>Skates</b> – ковзани<br>\n" +
                                    "- <b>Swimming goggles</b> – окуляри для плавання<br>\n" +
                                    "- <b>Bicycle</b> – велосипед<br>\n" +
                                    "- <b>Running shoes</b> – кросівки для бігу<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'ракетка' англійською?",
                            options = listOf("Helmet", "Racket", "Bicycle", "Ball"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Спортивні змагання (Sporting Competitions)</b><br>\n" +
                                    "- <b>Match</b> – матч<br>\n" +
                                    "- <b>Competition</b> – змагання<br>\n" +
                                    "- <b>Tournament</b> – турнір<br>\n" +
                                    "- <b>Championship</b> – чемпіонат<br>\n" +
                                    "- <b>Olympic Games</b> – Олімпійські ігри<br>\n" +
                                    "- <b>Marathon</b> – марафон<br>\n" +
                                    "- <b>World Cup</b> – Чемпіонат світу<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Олімпійські ігри' англійською?",
                            options = listOf("World Cup", "Olympic Games", "Marathon", "Championship"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Спортивні дії та терміни (Sports Actions and Terms)</b><br>\n" +
                                    "- <b>Win</b> – виграти<br>\n" +
                                    "- <b>Lose</b> – програти<br>\n" +
                                    "- <b>Draw</b> – нічия<br>\n" +
                                    "- <b>Score a goal</b> – забити гол<br>\n" +
                                    "- <b>Break a record</b> – побити рекорд<br>\n" +
                                    "- <b>Referee</b> – суддя<br>\n" +
                                    "- <b>Team</b> – команда<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'нічия' англійською?",
                            options = listOf("Win", "Draw", "Lose", "Break a record"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про спорт (Useful Sports Phrases)</b><br>\n" +
                                    "- <b>Who won the match?</b> – Хто виграв матч?<br>\n" +
                                    "- <b>The game ended in a draw.</b> – Гра закінчилася внічию.<br>\n" +
                                    "- <b>He scored a great goal!</b> – Він забив чудовий гол!<br>\n" +
                                    "- <b>They are training for the championship.</b> – Вони тренуються до чемпіонату.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Гра закінчилася внічию' англійською?",
                            options = listOf("Who won the match?", "The game ended in a draw.", "They are training for the championship.", "He scored a great goal!"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Види мистецтва: музика, живопис, театр",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Види мистецтва: музика, живопис, театр (Types of Art: Music, Painting, Theatre)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про різні види мистецтва, жанри музики, техніки живопису та театр.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Жанри музики (Music Genres)</b><br>\n" +
                                    "- <b>Classical</b> – класична музика<br>\n" +
                                    "- <b>Rock</b> – рок<br>\n" +
                                    "- <b>Pop</b> – поп-музика<br>\n" +
                                    "- <b>Jazz</b> – джаз<br>\n" +
                                    "- <b>Blues</b> – блюз<br>\n" +
                                    "- <b>Electronic</b> – електронна музика<br>\n" +
                                    "- <b>Hip-hop</b> – хіп-хоп<br>\n" +
                                    "- <b>Reggae</b> – регі<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'класична музика' англійською?",
                            options = listOf("Jazz", "Rock", "Classical", "Blues"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Живопис та техніки малювання (Painting and Drawing Techniques)</b><br>\n" +
                                    "- <b>Oil painting</b> – олійний живопис<br>\n" +
                                    "- <b>Watercolor</b> – акварель<br>\n" +
                                    "- <b>Sketch</b> – ескіз<br>\n" +
                                    "- <b>Portrait</b> – портрет<br>\n" +
                                    "- <b>Landscape</b> – пейзаж<br>\n" +
                                    "- <b>Abstract art</b> – абстрактне мистецтво<br>\n" +
                                    "- <b>Canvas</b> – полотно<br>\n" +
                                    "- <b>Sculpture</b> – скульптура<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'пейзаж' англійською?",
                            options = listOf("Canvas", "Portrait", "Landscape", "Sculpture"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Театр та акторське мистецтво (Theatre and Acting)</b><br>\n" +
                                    "- <b>Play</b> – п'єса<br>\n" +
                                    "- <b>Actor/Actress</b> – актор/актриса<br>\n" +
                                    "- <b>Stage</b> – сцена<br>\n" +
                                    "- <b>Audience</b> – глядачі<br>\n" +
                                    "- <b>Director</b> – режисер<br>\n" +
                                    "- <b>Musical</b> – мюзикл<br>\n" +
                                    "- <b>Costume</b> – костюм<br>\n" +
                                    "- <b>Drama</b> – драма<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'режисер' англійською?",
                            options = listOf("Actor", "Audience", "Director", "Stage"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як говорити про мистецтво? (Talking About Art)</b><br>\n" +
                                    "- <b>Who is your favorite artist?</b> – Хто твій улюблений художник?<br>\n" +
                                    "- <b>This painting is very beautiful.</b> – Ця картина дуже гарна.<br>\n" +
                                    "- <b>The play was amazing!</b> – П’єса була чудовою!<br>\n" +
                                    "- <b>I love listening to jazz music.</b> – Я люблю слухати джазову музику.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Ця картина дуже гарна' англійською?",
                            options = listOf("The play was amazing!", "Who is your favorite artist?", "I love listening to jazz music.", "This painting is very beautiful."),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про мистецтво (Useful Art Phrases)</b><br>\n" +
                                    "- <b>Have you ever been to an art gallery?</b> – Ти коли-небудь був у художній галереї?<br>\n" +
                                    "- <b>She is a talented actress.</b> – Вона талановита актриса.<br>\n" +
                                    "- <b>The museum has a great collection of paintings.</b> – У музеї є чудова колекція картин.<br>\n" +
                                    "- <b>That sculpture is very impressive.</b> – Ця скульптура дуже вражаюча.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Ця скульптура дуже вражаюча' англійською?",
                            options = listOf("That sculpture is very impressive.", "The museum has a great collection of paintings.", "She is a talented actress.", "Have you ever been to an art gallery?"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 13,
                    title = "Розділ 13",
                    topic = "Телебачення, кіно та медіа",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Телебачення, кіно та медіа (Television, Cinema, and Media)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про телебачення, кіноіндустрію, жанри фільмів та медіа.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Жанри фільмів (Movie Genres)</b><br>\n" +
                                    "- <b>Action</b> – бойовик<br>\n" +
                                    "- <b>Comedy</b> – комедія<br>\n" +
                                    "- <b>Drama</b> – драма<br>\n" +
                                    "- <b>Horror</b> – жахи<br>\n" +
                                    "- <b>Science fiction (Sci-Fi)</b> – наукова фантастика<br>\n" +
                                    "- <b>Romance</b> – романтичний фільм<br>\n" +
                                    "- <b>Documentary</b> – документальний фільм<br>\n" +
                                    "- <b>Animation</b> – анімація (мультфільм)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'комедія' англійською?",
                            options = listOf("Drama", "Horror", "Comedy", "Action"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Види телепередач (Types of TV Shows)</b><br>\n" +
                                    "- <b>News</b> – новини<br>\n" +
                                    "- <b>Talk show</b> – ток-шоу<br>\n" +
                                    "- <b>Reality show</b> – реаліті-шоу<br>\n" +
                                    "- <b>Sports program</b> – спортивна програма<br>\n" +
                                    "- <b>Soap opera</b> – мильна опера<br>\n" +
                                    "- <b>Documentary</b> – документальний фільм<br>\n" +
                                    "- <b>Game show</b> – телевізійна вікторина<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'новини' англійською?",
                            options = listOf("Soap opera", "Reality show", "News", "Talk show"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Люди в кіно та медіа (People in Film and Media)</b><br>\n" +
                                    "- <b>Actor/Actress</b> – актор/актриса<br>\n" +
                                    "- <b>Director</b> – режисер<br>\n" +
                                    "- <b>Producer</b> – продюсер<br>\n" +
                                    "- <b>Screenwriter</b> – сценарист<br>\n" +
                                    "- <b>Journalist</b> – журналіст<br>\n" +
                                    "- <b>News anchor</b> – ведучий новин<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'режисер' англійською?",
                            options = listOf("Journalist", "Director", "Screenwriter", "Producer"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як говорити про кіно та телебачення? (Talking About Movies and TV)</b><br>\n" +
                                    "- <b>What’s your favorite movie?</b> – Який твій улюблений фільм?<br>\n" +
                                    "- <b>I love action movies.</b> – Я люблю бойовики.<br>\n" +
                                    "- <b>This TV show is really entertaining.</b> – Це телевізійне шоу справді захопливе.<br>\n" +
                                    "- <b>The news is very informative.</b> – Новини дуже інформативні.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Який твій улюблений фільм?' англійською?",
                            options = listOf("What’s your favorite movie?", "What’s on TV tonight?", "Do you watch reality shows?", "Where is the cinema?"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази у сфері медіа (Useful Media Phrases)</b><br>\n" +
                                    "- <b>What time does the movie start?</b> – О котрій починається фільм?<br>\n" +
                                    "- <b>Can I get a ticket for the 7 PM show?</b> – Чи можу я отримати квиток на сеанс о 19:00?<br>\n" +
                                    "- <b>Let’s watch a movie tonight.</b> – Давай подивимося фільм сьогодні ввечері.<br>\n" +
                                    "- <b>Turn up the volume, please.</b> – Зроби звук голосніше, будь ласка.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Давай подивимося фільм сьогодні ввечері' англійською?",
                            options = listOf("Turn up the volume, please.", "Let’s watch a movie tonight.", "What time does the movie start?", "Can I get a ticket for the 7 PM show?"),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 14,
                    title = "Розділ 14",
                    topic = "Читання та література",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Читання та література (Reading and Literature)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про книги, жанри літератури, улюблених авторів та літературні терміни.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Жанри літератури (Literary Genres)</b><br>\n" +
                                    "- <b>Novel</b> – роман<br>\n" +
                                    "- <b>Short story</b> – коротке оповідання<br>\n" +
                                    "- <b>Poetry</b> – поезія<br>\n" +
                                    "- <b>Drama</b> – драма<br>\n" +
                                    "- <b>Mystery</b> – детектив<br>\n" +
                                    "- <b>Science fiction (Sci-Fi)</b> – наукова фантастика<br>\n" +
                                    "- <b>Fantasy</b> – фентезі<br>\n" +
                                    "- <b>Autobiography</b> – автобіографія<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'поезія' англійською?",
                            options = listOf("Drama", "Mystery", "Poetry", "Autobiography"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Частини книги (Parts of a Book)</b><br>\n" +
                                    "- <b>Cover</b> – обкладинка<br>\n" +
                                    "- <b>Title</b> – назва<br>\n" +
                                    "- <b>Chapter</b> – розділ<br>\n" +
                                    "- <b>Page</b> – сторінка<br>\n" +
                                    "- <b>Illustration</b> – ілюстрація<br>\n" +
                                    "- <b>Index</b> – зміст<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'обкладинка' англійською?",
                            options = listOf("Chapter", "Page", "Cover", "Title"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Люди в літературі (People in Literature)</b><br>\n" +
                                    "- <b>Author</b> – автор<br>\n" +
                                    "- <b>Poet</b> – поет<br>\n" +
                                    "- <b>Writer</b> – письменник<br>\n" +
                                    "- <b>Editor</b> – редактор<br>\n" +
                                    "- <b>Publisher</b> – видавець<br>\n" +
                                    "- <b>Reader</b> – читач<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'письменник' англійською?",
                            options = listOf("Editor", "Publisher", "Author", "Writer"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як говорити про книги? (Talking About Books)</b><br>\n" +
                                    "- <b>Who is your favorite author?</b> – Хто твій улюблений автор?<br>\n" +
                                    "- <b>This book is very interesting.</b> – Ця книга дуже цікава.<br>\n" +
                                    "- <b>I love reading science fiction.</b> – Я люблю читати наукову фантастику.<br>\n" +
                                    "- <b>The story has a surprising ending.</b> – У цієї історії несподіваний фінал.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Ця книга дуже цікава' англійською?",
                            options = listOf("The story has a surprising ending.", "I love reading science fiction.", "Who is your favorite author?", "This book is very interesting."),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про літературу (Useful Literature Phrases)</b><br>\n" +
                                    "- <b>Have you read this book?</b> – Ти читав цю книгу?<br>\n" +
                                    "- <b>The book is better than the movie.</b> – Книга краща за фільм.<br>\n" +
                                    "- <b>I couldn't put the book down.</b> – Я не міг відірватися від книги.<br>\n" +
                                    "- <b>This novel is a bestseller.</b> – Цей роман – бестселер.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Книга краща за фільм' англійською?",
                            options = listOf("The book is better than the movie.", "This novel is a bestseller.", "I couldn't put the book down.", "Have you read this book?"),
                            correctAnswerIndex = 0
                        )
                    )
                ),
                Lesson(
                    id = 15,
                    title = "Розділ 15",
                    topic = "Здоровий спосіб життя та харчування",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Здоровий спосіб життя та харчування (Healthy Lifestyle and Nutrition)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про здоровий спосіб життя, правильне харчування та фізичну активність.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Корисні та шкідливі звички (Healthy and Unhealthy Habits)</b><br>\n" +
                                    "- <b>Exercise regularly</b> – регулярно займатися спортом<br>\n" +
                                    "- <b>Eat healthy food</b> – вживати корисну їжу<br>\n" +
                                    "- <b>Drink enough water</b> – пити достатньо води<br>\n" +
                                    "- <b>Get enough sleep</b> – висипатися<br>\n" +
                                    "- <b>Avoid junk food</b> – уникати шкідливої їжі<br>\n" +
                                    "- <b>Quit smoking</b> – кинути палити<br>\n" +
                                    "- <b>Reduce stress</b> – зменшити стрес<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'регулярно займатися спортом' англійською?",
                            options = listOf("Eat healthy food", "Exercise regularly", "Reduce stress", "Get enough sleep"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>2. Основи правильного харчування (Basics of Healthy Eating)</b><br>\n" +
                                    "- <b>Fruits and vegetables</b> – фрукти та овочі<br>\n" +
                                    "- <b>Proteins</b> – білки<br>\n" +
                                    "- <b>Carbohydrates</b> – вуглеводи<br>\n" +
                                    "- <b>Fats</b> – жири<br>\n" +
                                    "- <b>Vitamins</b> – вітаміни<br>\n" +
                                    "- <b>Minerals</b> – мінерали<br>\n" +
                                    "- <b>Balanced diet</b> – збалансоване харчування<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'вітаміни' англійською?",
                            options = listOf("Fats", "Minerals", "Proteins", "Vitamins"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>3. Види фізичної активності (Types of Physical Activity)</b><br>\n" +
                                    "- <b>Running</b> – біг<br>\n" +
                                    "- <b>Swimming</b> – плавання<br>\n" +
                                    "- <b>Cycling</b> – велоспорт<br>\n" +
                                    "- <b>Yoga</b> – йога<br>\n" +
                                    "- <b>Weightlifting</b> – підняття ваги<br>\n" +
                                    "- <b>Walking</b> – ходьба<br>\n" +
                                    "- <b>Stretching</b> – розтяжка<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'біг' англійською?",
                            options = listOf("Yoga", "Cycling", "Running", "Stretching"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як підтримувати здоровий спосіб життя? (How to Maintain a Healthy Lifestyle)</b><br>\n" +
                                    "- <b>I try to eat more fruits and vegetables.</b> – Я намагаюся їсти більше фруктів та овочів.<br>\n" +
                                    "- <b>Drinking enough water is important.</b> – Пити достатньо води – це важливо.<br>\n" +
                                    "- <b>Regular exercise keeps me fit.</b> – Регулярні фізичні вправи підтримують мою форму.<br>\n" +
                                    "- <b>Getting enough sleep helps me feel good.</b> – Достатній сон допомагає мені почуватися добре.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Регулярні фізичні вправи підтримують мою форму' англійською?",
                            options = listOf("Drinking enough water is important.", "Regular exercise keeps me fit.", "I try to eat more fruits and vegetables.", "Getting enough sleep helps me feel good."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про здоровий спосіб життя (Useful Health Phrases)</b><br>\n" +
                                    "- <b>Do you exercise regularly?</b> – Ти регулярно займаєшся спортом?<br>\n" +
                                    "- <b>I feel great when I eat healthy.</b> – Я почуваюся чудово, коли правильно харчуюся.<br>\n" +
                                    "- <b>It’s important to stay active.</b> – Важливо залишатися активним.<br>\n" +
                                    "- <b>Too much sugar is bad for your health.</b> – Надмірна кількість цукру шкідлива для здоров’я.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Важливо залишатися активним' англійською?",
                            options = listOf("Do you exercise regularly?", "I feel great when I eat healthy.", "It’s important to stay active.", "Too much sugar is bad for your health."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 16,
                    title = "Розділ 16",
                    topic = "Робота та професійна діяльність",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Робота та професійна діяльність (Work and Professional Activity)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про професії, робочі завдання, процес пошуку роботи та кар'єрний розвиток.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Популярні професії (Common Professions)</b><br>\n" +
                                    "- <b>Doctor</b> – лікар<br>\n" +
                                    "- <b>Teacher</b> – вчитель<br>\n" +
                                    "- <b>Engineer</b> – інженер<br>\n" +
                                    "- <b>Accountant</b> – бухгалтер<br>\n" +
                                    "- <b>Lawyer</b> – юрист<br>\n" +
                                    "- <b>Software developer</b> – розробник програмного забезпечення<br>\n" +
                                    "- <b>Marketing specialist</b> – маркетолог<br>\n" +
                                    "- <b>Graphic designer</b> – графічний дизайнер<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'інженер' англійською?",
                            options = listOf("Doctor", "Teacher", "Engineer", "Lawyer"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Робочі обов'язки (Job Responsibilities)</b><br>\n" +
                                    "- <b>Meet deadlines</b> – дотримуватись строків<br>\n" +
                                    "- <b>Attend meetings</b> – відвідувати зустрічі<br>\n" +
                                    "- <b>Write reports</b> – писати звіти<br>\n" +
                                    "- <b>Work in a team</b> – працювати в команді<br>\n" +
                                    "- <b>Communicate with clients</b> – спілкуватися з клієнтами<br>\n" +
                                    "- <b>Analyze data</b> – аналізувати дані<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'працювати в команді' англійською?",
                            options = listOf("Write reports", "Attend meetings", "Work in a team", "Analyze data"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Пошук роботи (Job Search)</b><br>\n" +
                                    "- <b>Job interview</b> – співбесіда<br>\n" +
                                    "- <b>Resume (CV)</b> – резюме<br>\n" +
                                    "- <b>Job vacancy</b> – вакансія<br>\n" +
                                    "- <b>Cover letter</b> – супровідний лист<br>\n" +
                                    "- <b>Application form</b> – заява на роботу<br>\n" +
                                    "- <b>Salary expectations</b> – очікування щодо зарплати<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'співбесіда' англійською?",
                            options = listOf("Job interview", "Cover letter", "Application form", "Job vacancy"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>4. Кар'єрний розвиток (Career Development)</b><br>\n" +
                                    "- <b>Get a promotion</b> – отримати підвищення<br>\n" +
                                    "- <b>Gain experience</b> – отримати досвід<br>\n" +
                                    "- <b>Develop new skills</b> – розвивати нові навички<br>\n" +
                                    "- <b>Take a training course</b> – пройти навчальний курс<br>\n" +
                                    "- <b>Build a network</b> – налагоджувати контакти<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'отримати підвищення' англійською?",
                            options = listOf("Gain experience", "Get a promotion", "Take a training course", "Develop new skills"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про роботу (Useful Work Phrases)</b><br>\n" +
                                    "- <b>What do you do for a living?</b> – Чим ви заробляєте на життя?<br>\n" +
                                    "- <b>I work as a software developer.</b> – Я працюю розробником програмного забезпечення.<br>\n" +
                                    "- <b>My job is very interesting.</b> – Моя робота дуже цікава.<br>\n" +
                                    "- <b>I am looking for a new job.</b> – Я шукаю нову роботу.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чим ви заробляєте на життя?' англійською?",
                            options = listOf("My job is very interesting.", "I work as a software developer.", "What do you do for a living?", "I am looking for a new job."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 17,
                    title = "Розділ 17",
                    topic = "Співбесіда на роботу та резюме",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Співбесіда на роботу та резюме (Job Interview and Resume)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про підготовку до співбесіди, складати резюме та відповідати на типові запитання під час співбесіди.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Частини резюме (Parts of a Resume)</b><br>\n" +
                                    "- <b>Personal details</b> – особисті дані<br>\n" +
                                    "- <b>Work experience</b> – досвід роботи<br>\n" +
                                    "- <b>Education</b> – освіта<br>\n" +
                                    "- <b>Skills</b> – навички<br>\n" +
                                    "- <b>Achievements</b> – досягнення<br>\n" +
                                    "- <b>References</b> – рекомендації<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'досвід роботи' англійською?",
                            options = listOf("Skills", "Education", "Work experience", "Achievements"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Типові запитання на співбесіді (Common Job Interview Questions)</b><br>\n" +
                                    "- <b>Tell me about yourself.</b> – Розкажіть про себе.<br>\n" +
                                    "- <b>What are your strengths?</b> – Які ваші сильні сторони?<br>\n" +
                                    "- <b>What are your weaknesses?</b> – Які ваші слабкі сторони?<br>\n" +
                                    "- <b>Why do you want to work here?</b> – Чому ви хочете працювати тут?<br>\n" +
                                    "- <b>Where do you see yourself in five years?</b> – Де ви бачите себе через п’ять років?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Чому ви хочете працювати тут?' англійською?",
                            options = listOf("Tell me about yourself.", "What are your strengths?", "Why do you want to work here?", "Where do you see yourself in five years?"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Як говорити про свої навички? (Talking About Your Skills)</b><br>\n" +
                                    "- <b>I have strong communication skills.</b> – У мене сильні комунікативні навички.<br>\n" +
                                    "- <b>I am a team player.</b> – Я вмію працювати в команді.<br>\n" +
                                    "- <b>I have experience in project management.</b> – У мене є досвід управління проєктами.<br>\n" +
                                    "- <b>I am highly organized and detail-oriented.</b> – Я дуже організований і уважний до деталей.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я вмію працювати в команді' англійською?",
                            options = listOf("I have strong communication skills.", "I am highly organized and detail-oriented.", "I am a team player.", "I have experience in project management."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як обговорювати зарплату та умови роботи? (Discussing Salary and Work Conditions)</b><br>\n" +
                                    "- <b>What is the salary range for this position?</b> – Який діапазон зарплати для цієї посади?<br>\n" +
                                    "- <b>Are there opportunities for growth?</b> – Чи є можливості для кар'єрного зростання?<br>\n" +
                                    "- <b>What benefits does the company offer?</b> – Які пільги надає компанія?<br>\n" +
                                    "- <b>What are the working hours?</b> – Який графік роботи?<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як запитати 'Який графік роботи?' англійською?",
                            options = listOf("What benefits does the company offer?", "What are the working hours?", "Are there opportunities for growth?", "What is the salary range for this position?"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази для співбесіди (Useful Job Interview Phrases)</b><br>\n" +
                                    "- <b>Thank you for your time.</b> – Дякую за ваш час.<br>\n" +
                                    "- <b>I am very excited about this opportunity.</b> – Я дуже радий цій можливості.<br>\n" +
                                    "- <b>When can I expect to hear back from you?</b> – Коли я можу очікувати на відповідь?<br>\n" +
                                    "- <b>I look forward to working with you.</b> – Я з нетерпінням чекаю на можливість працювати з вами.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Дякую за ваш час' англійською?",
                            options = listOf("I look forward to working with you.", "When can I expect to hear back from you?", "I am very excited about this opportunity.", "Thank you for your time."),
                            correctAnswerIndex = 3
                        )
                    )
                ),
                Lesson(
                    id = 18,
                    title = "Розділ 18",
                    topic = "Освіта, навчальні заклади та предмети",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Освіта, навчальні заклади та предмети (Education, Educational Institutions, and Subjects)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про різні типи навчальних закладів, освітню систему та навчальні предмети.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Типи навчальних закладів (Types of Educational Institutions)</b><br>\n" +
                                    "- <b>Kindergarten</b> – дитячий садок<br>\n" +
                                    "- <b>Primary school</b> – початкова школа<br>\n" +
                                    "- <b>Secondary school</b> – середня школа<br>\n" +
                                    "- <b>High school</b> – старша школа<br>\n" +
                                    "- <b>University</b> – університет<br>\n" +
                                    "- <b>College</b> – коледж<br>\n" +
                                    "- <b>Vocational school</b> – професійне училище<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'університет' англійською?",
                            options = listOf("College", "Primary school", "University", "High school"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Навчальні предмети (School Subjects)</b><br>\n" +
                                    "- <b>Mathematics</b> – математика<br>\n" +
                                    "- <b>Physics</b> – фізика<br>\n" +
                                    "- <b>Chemistry</b> – хімія<br>\n" +
                                    "- <b>Biology</b> – біологія<br>\n" +
                                    "- <b>History</b> – історія<br>\n" +
                                    "- <b>Geography</b> – географія<br>\n" +
                                    "- <b>English</b> – англійська мова<br>\n" +
                                    "- <b>Computer Science</b> – інформатика<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'географія' англійською?",
                            options = listOf("Chemistry", "History", "Geography", "Biology"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>3. Освітні кваліфікації (Educational Qualifications)</b><br>\n" +
                                    "- <b>Diploma</b> – диплом<br>\n" +
                                    "- <b>Degree</b> – ступінь (бакалавра, магістра тощо)<br>\n" +
                                    "- <b>Certificate</b> – сертифікат<br>\n" +
                                    "- <b>Bachelor’s degree</b> – ступінь бакалавра<br>\n" +
                                    "- <b>Master’s degree</b> – ступінь магістра<br>\n" +
                                    "- <b>Doctorate (PhD)</b> – докторська ступінь<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'ступінь бакалавра' англійською?",
                            options = listOf("Diploma", "Certificate", "Bachelor’s degree", "Master’s degree"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Навчальний процес (Learning Process)</b><br>\n" +
                                    "- <b>Attend classes</b> – відвідувати заняття<br>\n" +
                                    "- <b>Take notes</b> – робити записи<br>\n" +
                                    "- <b>Pass an exam</b> – скласти іспит<br>\n" +
                                    "- <b>Fail an exam</b> – провалити іспит<br>\n" +
                                    "- <b>Do homework</b> – виконувати домашнє завдання<br>\n" +
                                    "- <b>Prepare for a test</b> – готуватися до тесту<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'скласти іспит' англійською?",
                            options = listOf("Pass an exam", "Fail an exam", "Take notes", "Do homework"),
                            correctAnswerIndex = 0
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про освіту (Useful Education Phrases)</b><br>\n" +
                                    "- <b>What’s your favorite subject?</b> – Який твій улюблений предмет?<br>\n" +
                                    "- <b>I am studying for my exams.</b> – Я готуюся до іспитів.<br>\n" +
                                    "- <b>She has a degree in engineering.</b> – Вона має ступінь у сфері інженерії.<br>\n" +
                                    "- <b>Our school offers many extracurricular activities.</b> – Наша школа пропонує багато позакласних занять.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Я готуюся до іспитів' англійською?",
                            options = listOf("What’s your favorite subject?", "I am studying for my exams.", "She has a degree in engineering.", "Our school offers many extracurricular activities."),
                            correctAnswerIndex = 1
                        )
                    )
                ),
                Lesson(
                    id = 19,
                    title = "Розділ 19",
                    topic = "Технології та наукові відкриття",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Технології та наукові відкриття (Technology and Scientific Discoveries)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про сучасні технології, наукові досягнення та їхній вплив на наше життя.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Сучасні технології (Modern Technologies)</b><br>\n" +
                                    "- <b>Artificial Intelligence (AI)</b> – штучний інтелект<br>\n" +
                                    "- <b>Virtual Reality (VR)</b> – віртуальна реальність<br>\n" +
                                    "- <b>Smartphone</b> – смартфон<br>\n" +
                                    "- <b>Cloud computing</b> – хмарні обчислення<br>\n" +
                                    "- <b>Blockchain</b> – блокчейн<br>\n" +
                                    "- <b>Electric vehicle</b> – електромобіль<br>\n" +
                                    "- <b>Wearable technology</b> – носимі технології (смарт-годинники, фітнес-браслети)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'віртуальна реальність' англійською?",
                            options = listOf("Blockchain", "Artificial Intelligence", "Virtual Reality", "Cloud computing"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Наукові відкриття (Scientific Discoveries)</b><br>\n" +
                                    "- <b>DNA structure</b> – структура ДНК<br>\n" +
                                    "- <b>Space exploration</b> – дослідження космосу<br>\n" +
                                    "- <b>Vaccines</b> – вакцини<br>\n" +
                                    "- <b>Quantum computing</b> – квантові обчислення<br>\n" +
                                    "- <b>Robotics</b> – робототехніка<br>\n" +
                                    "- <b>Genetic engineering</b> – генно-інженерія<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'квантові обчислення' англійською?",
                            options = listOf("Robotics", "Quantum computing", "Genetic engineering", "DNA structure"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Види гаджетів та їхні функції (Types of Gadgets and Their Functions)</b><br>\n" +
                                    "- <b>Smartphone</b> – смартфон (дзвінки, інтернет, додатки)<br>\n" +
                                    "- <b>Tablet</b> – планшет (мобільні пристрої для роботи та навчання)<br>\n" +
                                    "- <b>Smartwatch</b> – розумний годинник (фітнес-трекінг, повідомлення)<br>\n" +
                                    "- <b>Drone</b> – дрон (аерозйомка, доставка товарів)<br>\n" +
                                    "- <b>VR headset</b> – гарнітура VR (ігри, віртуальні презентації)<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'розумний годинник' англійською?",
                            options = listOf("Drone", "VR headset", "Smartwatch", "Tablet"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як технології змінюють наше життя? (How Technology Changes Our Lives)</b><br>\n" +
                                    "- <b>Technology makes communication faster.</b> – Технології роблять комунікацію швидшою.<br>\n" +
                                    "- <b>Online learning is becoming more popular.</b> – Онлайн-навчання стає дедалі популярнішим.<br>\n" +
                                    "- <b>Smart homes improve energy efficiency.</b> – Розумні будинки покращують енергоефективність.<br>\n" +
                                    "- <b>AI is used in healthcare and business.</b> – Штучний інтелект використовується в медицині та бізнесі.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Онлайн-навчання стає дедалі популярнішим' англійською?",
                            options = listOf("Technology makes communication faster.", "Online learning is becoming more popular.", "AI is used in healthcare and business.", "Smart homes improve energy efficiency."),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про технології (Useful Technology Phrases)</b><br>\n" +
                                    "- <b>What’s the latest tech innovation?</b> – Яке останнє технологічне нововведення?<br>\n" +
                                    "- <b>I love using new gadgets.</b> – Я люблю користуватися новими гаджетами.<br>\n" +
                                    "- <b>Artificial intelligence is the future.</b> – Штучний інтелект – це майбутнє.<br>\n" +
                                    "- <b>Self-driving cars are becoming more common.</b> – Автомобілі з автопілотом стають дедалі популярнішими.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Штучний інтелект – це майбутнє' англійською?",
                            options = listOf("Self-driving cars are becoming more common.", "What’s the latest tech innovation?", "Artificial intelligence is the future.", "I love using new gadgets."),
                            correctAnswerIndex = 2
                        )
                    )
                ),
                Lesson(
                    id = 20,
                    title = "Розділ 20",
                    topic = "Інтернет, соцмережі та безпека онлайн",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Інтернет, соцмережі та безпека онлайн (Internet, Social Media, and Online Safety)</b><br>\n" +
                                    "У цьому розділі ви навчитеся говорити про інтернет, соціальні мережі та основи безпеки в мережі.<br>\n" +
                                    "<br>\n" +
                                    "<b>1. Основні терміни інтернету (Basic Internet Terms)</b><br>\n" +
                                    "- <b>Website</b> – вебсайт<br>\n" +
                                    "- <b>Search engine</b> – пошукова система<br>\n" +
                                    "- <b>Web browser</b> – веббраузер<br>\n" +
                                    "- <b>Online shopping</b> – онлайн-покупки<br>\n" +
                                    "- <b>Streaming</b> – потокове мовлення (відео, музика)<br>\n" +
                                    "- <b>Download</b> – завантаження<br>\n" +
                                    "- <b>Upload</b> – вивантаження<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'пошукова система' англійською?",
                            options = listOf("Web browser", "Website", "Search engine", "Streaming"),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>2. Соціальні мережі (Social Media)</b><br>\n" +
                                    "- <b>Social network</b> – соціальна мережа<br>\n" +
                                    "- <b>Post</b> – публікація<br>\n" +
                                    "- <b>Comment</b> – коментар<br>\n" +
                                    "- <b>Like</b> – вподобання (лайк)<br>\n" +
                                    "- <b>Share</b> – поділитися<br>\n" +
                                    "- <b>Follower</b> – підписник<br>\n" +
                                    "- <b>Live stream</b> – пряма трансляція<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'підписник' англійською?",
                            options = listOf("Post", "Follower", "Comment", "Like"),
                            correctAnswerIndex = 1
                        ),
                        LessonStage.Content(
                            text = "<b>3. Безпека в інтернеті (Internet Safety)</b><br>\n" +
                                    "- <b>Strong password</b> – надійний пароль<br>\n" +
                                    "- <b>Cybersecurity</b> – кібербезпека<br>\n" +
                                    "- <b>Privacy settings</b> – налаштування конфіденційності<br>\n" +
                                    "- <b>Phishing</b> – фішинг (інтернет-шахрайство)<br>\n" +
                                    "- <b>Spam</b> – спам<br>\n" +
                                    "- <b>Two-factor authentication</b> – двофакторна автентифікація<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'налаштування конфіденційності' англійською?",
                            options = listOf("Phishing", "Spam", "Two-factor authentication", "Privacy settings"),
                            correctAnswerIndex = 3
                        ),
                        LessonStage.Content(
                            text = "<b>4. Як безпечно користуватися інтернетом? (How to Stay Safe Online)</b><br>\n" +
                                    "- <b>Never share your password with anyone.</b> – Ніколи не діліться своїм паролем з іншими.<br>\n" +
                                    "- <b>Be careful when clicking unknown links.</b> – Будьте обережні, натискаючи на невідомі посилання.<br>\n" +
                                    "- <b>Enable two-factor authentication for extra security.</b> – Увімкніть двофакторну автентифікацію для додаткової безпеки.<br>\n" +
                                    "- <b>Use strong and unique passwords for each account.</b> – Використовуйте надійні та унікальні паролі для кожного акаунта.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Будьте обережні, натискаючи на невідомі посилання' англійською?",
                            options = listOf("Use strong and unique passwords for each account.", "Never share your password with anyone.", "Be careful when clicking unknown links.", "Enable two-factor authentication for extra security."),
                            correctAnswerIndex = 2
                        ),
                        LessonStage.Content(
                            text = "<b>5. Корисні фрази про інтернет (Useful Internet Phrases)</b><br>\n" +
                                    "- <b>Do you use social media?</b> – Ти користуєшся соціальними мережами?<br>\n" +
                                    "- <b>Can you send me the link?</b> – Можеш надіслати мені посилання?<br>\n" +
                                    "- <b>Be careful with online scams.</b> – Будьте обережні з онлайн-шахрайством.<br>\n" +
                                    "- <b>I always check my privacy settings.</b> – Я завжди перевіряю свої налаштування конфіденційності.<br>\n"
                        ),
                        LessonStage.Quiz(
                            question = "Як сказати 'Можеш надіслати мені посилання?' англійською?",
                            options = listOf("Do you use social media?", "I always check my privacy settings.", "Be careful with online scams.", "Can you send me the link?"),
                            correctAnswerIndex = 3
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_vocabulary_a2
        ),
        Course(
            id = 5,
            title = "Слова",
            level = "Англійська рівень А1",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Вітання",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>classroom</b> – класна кімната<br>\n" +
                                    "- <b>TV studio</b> – телестудія<br>\n" +
                                    "- <b>airport</b> – аеропорт<br>\n" +
                                    "- <b>street</b> – вулиця<br>\n" +
                                    "- <b>office</b> – офіс<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'classroom'?",
                                    options = listOf("Класна кімната", "Вулиця", "Офіс", "Аеропорт"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'TV studio'?",
                                    options = listOf("Кухня", "Телестудія", "Спальня", "Гараж"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'airport'?",
                                    options = listOf("Лікарня", "Аеропорт", "Школа", "Парк"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'street'?",
                                    options = listOf("Міст", "Парк", "Вулиця", "Літак"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'office'?",
                                    options = listOf("Ресторан", "Магазин", "Офіс", "Станція"),
                                    correctAnswerIndex = 2
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>camera</b> – фотокамера<br>\n" +
                                    "- <b>laptop</b> – ноутбук<br>\n" +
                                    "- <b>diary</b> – щоденник<br>\n" +
                                    "- <b>magazine</b> – журнал<br>\n" +
                                    "- <b>hairbrush</b> – щітка для волосся<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'camera'?",
                                    options = listOf("Фотокамера", "Книга", "Годинник", "Комп’ютер"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'laptop'?",
                                    options = listOf("Телефон", "Ноутбук", "Календар", "Чашка"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'diary'?",
                                    options = listOf("Календар", "Журнал", "Щоденник", "Фотоапарат"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'magazine'?",
                                    options = listOf("Газета", "Журнал", "Блокнот", "Дошка"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'hairbrush'?",
                                    options = listOf("Щітка для волосся", "Пензлик", "Гребінець", "Дзеркало"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Спосіб життя",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to read</b> – читати<br>\n" +
                                    "- <b>to listen to</b> – слухати<br>\n" +
                                    "- <b>to eat</b> – їсти<br>\n" +
                                    "- <b>to play</b> – грати<br>\n" +
                                    "- <b>to go</b> – йти<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to read'?",
                                    options = listOf("Читати", "Говорити", "Грати", "Малювати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to listen to'?",
                                    options = listOf("Читати", "Слухати", "Писати", "Гуляти"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to eat'?",
                                    options = listOf("Спати", "Готувати", "Їсти", "Пити"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to play'?",
                                    options = listOf("Грати", "Бігати", "Плавати", "Дивитися"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go'?",
                                    options = listOf("Говорити", "Йти", "Сидіти", "Читати"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>tea</b> – чай<br>\n" +
                                    "- <b>swimming</b> – плавання<br>\n" +
                                    "- <b>to get up</b> – вставати (прокидатися)<br>\n" +
                                    "- <b>to go to bed</b> – йти спати<br>\n" +
                                    "- <b>to have breakfast</b> – снідати<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'tea'?",
                                    options = listOf("Кава", "Чай", "Молоко", "Сік"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'swimming'?",
                                    options = listOf("Біг", "Плавання", "Гра", "Малювання"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to get up'?",
                                    options = listOf("Лягати спати", "Вставати", "Снідати", "Гуляти"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go to bed'?",
                                    options = listOf("Готувати їжу", "Працювати", "Йти спати", "Читати книгу"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to have breakfast'?",
                                    options = listOf("Обідати", "Вечеряти", "Снідати", "Гуляти"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Люди",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>intelligent</b> – розумний<br>\n" +
                                    "- <b>kind</b> – ласкавий<br>\n" +
                                    "- <b>talkative</b> – балакучий<br>\n" +
                                    "- <b>friendly</b> – дружній<br>\n" +
                                    "- <b>funny</b> – веселий<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'intelligent'?",
                                    options = listOf("Розумний", "Дружній", "Ласкавий", "Серйозний"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'kind'?",
                                    options = listOf("Ласкавий", "Шумний", "Тихий", "Серйозний"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'talkative'?",
                                    options = listOf("Балакучий", "Серйозний", "Веселий", "Сумний"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'friendly'?",
                                    options = listOf("Дружній", "Дурний", "Тихий", "Неласкавий"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'funny'?",
                                    options = listOf("Веселий", "Серйозний", "Дружній", "Ласкавий"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>stupid</b> – дурний<br>\n" +
                                    "- <b>serious</b> – серйозний<br>\n" +
                                    "- <b>unfriendly</b> – недружній<br>\n" +
                                    "- <b>quiet</b> – тихий<br>\n" +
                                    "- <b>unkind</b> – неласкавий<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'stupid'?",
                                    options = listOf("Розумний", "Дурний", "Балакучий", "Веселий"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'serious'?",
                                    options = listOf("Ласкавий", "Веселий", "Серйозний", "Тихий"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'unfriendly'?",
                                    options = listOf("Дружній", "Недружній", "Ласкавий", "Розумний"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'quiet'?",
                                    options = listOf("Балакучий", "Шумний", "Тихий", "Веселий"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'unkind'?",
                                    options = listOf("Ласкавий", "Недружній", "Неласкавий", "Дружній"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Місця",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>room</b> – кімната<br>\n" +
                                    "- <b>furniture</b> – меблі<br>\n" +
                                    "- <b>living room</b> – вітальня<br>\n" +
                                    "- <b>kitchen</b> – кухня<br>\n" +
                                    "- <b>dining room</b> – їдальня<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'room'?",
                                    options = listOf("Вітальня", "Кімната", "Їдальня", "Кухня"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'furniture'?",
                                    options = listOf("Меблі", "Кухня", "Диван", "Стеля"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'living room'?",
                                    options = listOf("Їдальня", "Спальня", "Вітальня", "Ванна кімната"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'kitchen'?",
                                    options = listOf("Кухня", "Вітальня", "Спальня", "Ванна кімната"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'dining room'?",
                                    options = listOf("Кухня", "Їдальня", "Спальня", "Гардероб"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>bathroom</b> – ванна кімната<br>\n" +
                                    "- <b>balcony</b> – балкон<br>\n" +
                                    "- <b>bedroom</b> – спальня<br>\n" +
                                    "- <b>hall</b> – коридор<br>\n" +
                                    "- <b>cupboard</b> – буфет, сервант<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'bathroom'?",
                                    options = listOf("Спальня", "Ванна кімната", "Їдальня", "Вітальня"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'balcony'?",
                                    options = listOf("Балкон", "Горище", "Гараж", "Кухня"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'bedroom'?",
                                    options = listOf("Кімната", "Спальня", "Кухня", "Ванна кімната"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'hall'?",
                                    options = listOf("Коридор", "Спальня", "Гараж", "Балкон"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'cupboard'?",
                                    options = listOf("Стіл", "Сервант", "Крісло", "Шафа"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Їжа",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>eggs</b> – яйця<br>\n" +
                                    "- <b>milk</b> – молоко<br>\n" +
                                    "- <b>banana</b> – банан<br>\n" +
                                    "- <b>apple</b> – яблуко<br>\n" +
                                    "- <b>carrot</b> – морква<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'eggs'?",
                                    options = listOf("Молоко", "Яйця", "Банани", "Яблука"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'milk'?",
                                    options = listOf("Молоко", "Вода", "Йогурт", "Сік"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'banana'?",
                                    options = listOf("Яблуко", "Груша", "Банан", "Слива"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'apple'?",
                                    options = listOf("Апельсин", "Яблуко", "Виноград", "Лимон"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'carrot'?",
                                    options = listOf("Огірок", "Помідор", "Морква", "Капуста"),
                                    correctAnswerIndex = 2
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>chicken</b> – курка<br>\n" +
                                    "- <b>butter</b> – масло<br>\n" +
                                    "- <b>water</b> – вода<br>\n" +
                                    "- <b>cucumber</b> – огірок<br>\n" +
                                    "- <b>sardines</b> – сардини<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'chicken'?",
                                    options = listOf("Яйце", "Курка", "М'ясо", "Сир"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'butter'?",
                                    options = listOf("Масло", "Молоко", "Йогурт", "Сметана"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'water'?",
                                    options = listOf("Чай", "Вода", "Сік", "Кава"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'cucumber'?",
                                    options = listOf("Капуста", "Огірок", "Морква", "Гарбуз"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'sardines'?",
                                    options = listOf("Оселедець", "Тунець", "Сардини", "Лосось"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Минулий час",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to like</b> – подобатися<br>\n" +
                                    "- <b>to move</b> – рухатися<br>\n" +
                                    "- <b>to want</b> – хотіти<br>\n" +
                                    "- <b>to start</b> – починати<br>\n" +
                                    "- <b>to work</b> – працювати<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to like'?",
                                    options = listOf("Ненавидіти", "Подобатися", "Любити", "Відчувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to move'?",
                                    options = listOf("Стояти", "Рухатися", "Говорити", "Плавати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to want'?",
                                    options = listOf("Мати", "Бажати", "Хотіти", "Знати"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to start'?",
                                    options = listOf("Починати", "Закінчувати", "Зупинятися", "Гуляти"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to work'?",
                                    options = listOf("Вчитися", "Працювати", "Подорожувати", "Читати"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to live</b> – жити<br>\n" +
                                    "- <b>to stop</b> – зупинятися<br>\n" +
                                    "- <b>to meet</b> – зустрічати<br>\n" +
                                    "- <b>to get married</b> – одружуватися<br>\n" +
                                    "- <b>to rent</b> – орендувати<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to live'?",
                                    options = listOf("Жити", "Знати", "Робити", "Думати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to stop'?",
                                    options = listOf("Починати", "Зупинятися", "Грати", "Чекати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to meet'?",
                                    options = listOf("Говорити", "Дивитися", "Зустрічати", "Читати"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to get married'?",
                                    options = listOf("Одружуватися", "Подорожувати", "Купувати", "Будувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to rent'?",
                                    options = listOf("Продавати", "Орендувати", "Будувати", "Грати"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Канікули та подорожі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>good</b> – хороший<br>\n" +
                                    "- <b>fast</b> – швидкий<br>\n" +
                                    "- <b>crowded</b> – переповнений<br>\n" +
                                    "- <b>expensive</b> – дорогий<br>\n" +
                                    "- <b>hot</b> – спекотний<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'good'?",
                                    options = listOf("Поганий", "Гарний", "Швидкий", "Зручний"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'fast'?",
                                    options = listOf("Швидкий", "Повільний", "Дорогий", "Теплий"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'crowded'?",
                                    options = listOf("Порожній", "Комфортний", "Переповнений", "Гарний"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'expensive'?",
                                    options = listOf("Дешевий", "Дорогий", "Тихий", "Величезний"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'hot'?",
                                    options = listOf("Гарячий", "Холодний", "Зручний", "Повільний"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>comfortable</b> – зручний<br>\n" +
                                    "- <b>interesting</b> – цікавий<br>\n" +
                                    "- <b>quiet</b> – тихий<br>\n" +
                                    "- <b>noisy</b> – шумний<br>\n" +
                                    "- <b>empty</b> – порожній<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'comfortable'?",
                                    options = listOf("Незручний", "Зручний", "Повільний", "Теплий"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'interesting'?",
                                    options = listOf("Сумний", "Цікавий", "Швидкий", "Нудний"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'quiet'?",
                                    options = listOf("Шумний", "Гучний", "Тихий", "Повільний"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'noisy'?",
                                    options = listOf("Спекотний", "Тихий", "Шумний", "Комфортний"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'empty'?",
                                    options = listOf("Повний", "Порожній", "Дорогий", "Легкий"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Зараз та зовнішність",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to take photos</b> – фотографувати<br>\n" +
                                    "- <b>to share</b> – ділитися<br>\n" +
                                    "- <b>to put</b> – класти<br>\n" +
                                    "- <b>to lie</b> – лежати; брехати<br>\n" +
                                    "- <b>to chat</b> – бесідувати<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to take photos'?",
                                    options = listOf("Фотографувати", "Говорити", "Малювати", "Читати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to share'?",
                                    options = listOf("Ділитися", "Ховати", "Писати", "Думати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to put'?",
                                    options = listOf("Бігти", "Класти", "Купувати", "Грати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to lie'?",
                                    options = listOf("Чекати", "Лежати; брехати", "Спати", "Стояти"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to chat'?",
                                    options = listOf("Розмовляти", "Малювати", "Дивитися", "Бігати"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>curly hair</b> – кучеряве волосся<br>\n" +
                                    "- <b>beard</b> – борода<br>\n" +
                                    "- <b>moustache</b> – вуса<br>\n" +
                                    "- <b>make-up</b> – макіяж<br>\n" +
                                    "- <b>earrings</b> – кульчики<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'curly hair'?",
                                    options = listOf("Коротке волосся", "Кучеряве волосся", "Пряме волосся", "Русяве волосся"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'beard'?",
                                    options = listOf("Вуса", "Борода", "Зачіска", "Гребінець"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'moustache'?",
                                    options = listOf("Вуса", "Борода", "Брови", "Губи"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'make-up'?",
                                    options = listOf("Макіяж", "Шампунь", "Крем", "Парфуми"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'earrings'?",
                                    options = listOf("Кільця", "Браслет", "Кульчики", "Годинник"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Транспорт",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>bus</b> – автобус<br>\n" +
                                    "- <b>plane</b> – літак<br>\n" +
                                    "- <b>train</b> – поїзд<br>\n" +
                                    "- <b>tram</b> – трамвай<br>\n" +
                                    "- <b>helicopter</b> – гвинтокрил<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'bus'?",
                                    options = listOf("Автобус", "Літак", "Поїзд", "Трамвай"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'plane'?",
                                    options = listOf("Трамвай", "Літак", "Гвинтокрил", "Автобус"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'train'?",
                                    options = listOf("Гвинтокрил", "Автобус", "Поїзд", "Трамвай"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'tram'?",
                                    options = listOf("Поїзд", "Трамвай", "Літак", "Гвинтокрил"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'helicopter'?",
                                    options = listOf("Гвинтокрил", "Літак", "Трамвай", "Поїзд"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>bike</b> – велосипед<br>\n" +
                                    "- <b>motorbike</b> – мотоцикл<br>\n" +
                                    "- <b>horse</b> – кінь<br>\n" +
                                    "- <b>lorry</b> – вантажівка<br>\n" +
                                    "- <b>taxi</b> – таксі<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'bike'?",
                                    options = listOf("Автобус", "Велосипед", "Мотоцикл", "Гвинтокрил"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'motorbike'?",
                                    options = listOf("Літак", "Мотоцикл", "Кінь", "Велосипед"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'horse'?",
                                    options = listOf("Кінь", "Вантажівка", "Таксі", "Літак"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'lorry'?",
                                    options = listOf("Велосипед", "Мотоцикл", "Вантажівка", "Гвинтокрил"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'taxi'?",
                                    options = listOf("Таксі", "Кінь", "Літак", "Поїзд"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "Майбутнє",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>couple</b> – пара<br>\n" +
                                    "- <b>to win</b> – вигравати<br>\n" +
                                    "- <b>to stay</b> – залишатися<br>\n" +
                                    "- <b>to treat</b> – пригощати<br>\n" +
                                    "- <b>to travel around the world</b> – подорожувати світом<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'couple'?",
                                    options = listOf("Пара", "Родина", "Друзі", "Команда"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to win'?",
                                    options = listOf("Грати", "Вигравати", "Змагатися", "Готувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to stay'?",
                                    options = listOf("Їхати", "Залишатися", "Розмовляти", "Ходити"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to treat'?",
                                    options = listOf("Пригощати", "Думати", "Розмовляти", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to travel around the world'?",
                                    options = listOf("Жити у місті", "Подорожувати світом", "Вчитися", "Знайомитися"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>boat</b> – човен<br>\n" +
                                    "- <b>to swim</b> – плавати<br>\n" +
                                    "- <b>to sail</b> – плавати (човном)<br>\n" +
                                    "- <b>great</b> – чудовий<br>\n" +
                                    "- <b>brilliant</b> – блискучий<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'boat'?",
                                    options = listOf("Човен", "Літак", "Поїзд", "Автомобіль"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to swim'?",
                                    options = listOf("Бігати", "Плавати", "Грати", "Стрибати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to sail'?",
                                    options = listOf("Плавати (човном)", "Їздити на велосипеді", "Грати у футбол", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'great'?",
                                    options = listOf("Чудовий", "Жахливий", "Нудний", "Темний"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'brilliant'?",
                                    options = listOf("Темний", "Нудний", "Блискучий", "Складний"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Здоров'я",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>a runny nose</b> – нежить<br>\n" +
                                    "- <b>a leg hurts</b> – нога болить<br>\n" +
                                    "- <b>a sore throat</b> – запалене горло<br>\n" +
                                    "- <b>a cough</b> – кашель<br>\n" +
                                    "- <b>a headache</b> – головний біль<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'a runny nose'?",
                                    options = listOf("Головний біль", "Нежить", "Температура", "Кашель"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'a leg hurts'?",
                                    options = listOf("Нога болить", "Рука болить", "Горло болить", "Живіт болить"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'a sore throat'?",
                                    options = listOf("Запалене горло", "Нога болить", "Головний біль", "Нежить"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'a cough'?",
                                    options = listOf("Температура", "Нежить", "Кашель", "Біль у животі"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'a headache'?",
                                    options = listOf("Нежить", "Головний біль", "Горло болить", "Нога болить"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>a temperature</b> – температура<br>\n" +
                                    "- <b>medicine</b> – ліки<br>\n" +
                                    "- <b>to fight</b> – боротися<br>\n" +
                                    "- <b>honey</b> – мед<br>\n" +
                                    "- <b>herbal tea</b> – трав'яний чай<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'a temperature'?",
                                    options = listOf("Головний біль", "Температура", "Кашель", "Нежить"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'medicine'?",
                                    options = listOf("Ліки", "Вода", "Чай", "Мед"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to fight'?",
                                    options = listOf("Відпочивати", "Боротися", "Працювати", "Готувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'honey'?",
                                    options = listOf("Молоко", "Цукор", "Мед", "Сир"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'herbal tea'?",
                                    options = listOf("Чорний чай", "Трав'яний чай", "Кава", "Сік"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Досвід та почуття",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>inside</b> – всередині<br>\n" +
                                    "- <b>outside</b> – ззовні<br>\n" +
                                    "- <b>stunt</b> – каскадер<br>\n" +
                                    "- <b>afraid</b> – наляканий<br>\n" +
                                    "- <b>through</b> – через<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'inside'?",
                                    options = listOf("Ззовні", "Всередині", "Навколо", "Попереду"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'outside'?",
                                    options = listOf("Всередині", "Ззовні", "Під", "Між"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'stunt'?",
                                    options = listOf("Каскадер", "Дизайнер", "Фотограф", "Пілот"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'afraid'?",
                                    options = listOf("Веселий", "Злий", "Наляканий", "Сумний"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'through'?",
                                    options = listOf("Поверх", "Через", "Під", "Біля"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to choose</b> – обирати<br>\n" +
                                    "- <b>to bring</b> – приносити<br>\n" +
                                    "- <b>to fly</b> – літати<br>\n" +
                                    "- <b>to tell</b> – розповідати<br>\n" +
                                    "- <b>to call</b> – дзвонити<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to choose'?",
                                    options = listOf("Обирати", "Писати", "Говорити", "Співати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to bring'?",
                                    options = listOf("Грати", "Бігати", "Приносити", "Відпочивати"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to fly'?",
                                    options = listOf("Літати", "Плавати", "Бігати", "Ходити"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to tell'?",
                                    options = listOf("Малювати", "Розповідати", "Готувати", "Чекати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to call'?",
                                    options = listOf("Дзвонити", "Грати", "Зустрічати", "Бігти"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_words_a1
        ),
        Course(
            id = 6,
            title = "Слова",
            level = "Англійська рівень А2",
            lessons = listOf(
                Lesson(
                    id = 1,
                    title = "Розділ 1",
                    topic = "Життя",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to go shopping</b> – закуповуватися<br>\n" +
                                    "- <b>to go on holiday</b> – їхати у відпустку<br>\n" +
                                    "- <b>to spend time with family</b> – проводити час із сім'єю<br>\n" +
                                    "- <b>to spend money</b> – витрачати гроші<br>\n" +
                                    "- <b>to eat out</b> – їсти не вдома (в ресторані чи кафе)<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to go shopping'?",
                                    options = listOf("Закуповуватися", "Відпочивати", "Гуляти", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go on holiday'?",
                                    options = listOf("Їхати у відпустку", "Проводити час із сім'єю", "Їсти не вдома", "Відпочивати вдома"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to spend time with family'?",
                                    options = listOf("Витрачати гроші", "Гуляти в парку", "Проводити час із сім'єю", "Зустрічатися з друзями"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to spend money'?",
                                    options = listOf("Заробляти гроші", "Витрачати гроші", "Економити гроші", "Купувати новий телефон"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to eat out'?",
                                    options = listOf("Готувати вдома", "Їсти не вдома", "Їсти сніданок", "Збиратися на обід"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to have time off</b> – мати вихідний день / вільний від роботи час<br>\n" +
                                    "- <b>to have a barbecue</b> – влаштувати барбекю<br>\n" +
                                    "- <b>to play (a) sport</b> – займатися спортом<br>\n" +
                                    "- <b>to play (the piano / the violin)</b> – грати (на фортепіано / скрипці)<br>\n" +
                                    "- <b>to go out</b> – вийти погуляти / проводити час не вдома<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to have time off'?",
                                    options = listOf("Мати вихідний день", "Мати багато роботи", "Заробляти гроші", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to have a barbecue'?",
                                    options = listOf("Готувати вдома", "Влаштувати барбекю", "Їсти у ресторані", "Збиратися з друзями"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to play (a) sport'?",
                                    options = listOf("Дивитися спорт", "Займатися спортом", "Грати в комп'ютерні ігри", "Подорожувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to play (the piano / the violin)'?",
                                    options = listOf("Грати на фортепіано / скрипці", "Грати в теніс", "Грати у футбол", "Співати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go out'?",
                                    options = listOf("Залишатися вдома", "Вийти погуляти / проводити час не вдома", "Готувати їжу", "Дивитися телевізор"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 2,
                    title = "Розділ 2",
                    topic = "Робота",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>employee</b> – найманий працівник<br>\n" +
                                    "- <b>salary</b> – зарплата (за місяць)<br>\n" +
                                    "- <b>wage</b> – зарплата (за тиждень)<br>\n" +
                                    "- <b>customer</b> – покупець / клієнт<br>\n" +
                                    "- <b>staff</b> – робочий персонал<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'employee'?",
                                    options = listOf("Клієнт", "Менеджер", "Найманий працівник", "Директор"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'salary'?",
                                    options = listOf("Зарплата (за місяць)", "Грошовий бонус", "Кредит", "Рахунок"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'wage'?",
                                    options = listOf("Податки", "Зарплата (за тиждень)", "Грошові заощадження", "Кредитна картка"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'customer'?",
                                    options = listOf("Працівник", "Покупець / клієнт", "Підприємець", "Заробітчанин"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'staff'?",
                                    options = listOf("Клієнти", "Заробітна плата", "Робочий персонал", "Менеджери"),
                                    correctAnswerIndex = 2
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to provide services</b> – надавати послуги<br>\n" +
                                    "- <b>to do a job</b> – виконувати роботу<br>\n" +
                                    "- <b>to manage</b> – керувати<br>\n" +
                                    "- <b>to have a break</b> – мати перерву<br>\n" +
                                    "- <b>temporary situation</b> – тимчасова ситуація<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to provide services'?",
                                    options = listOf("Надавати послуги", "Виконувати завдання", "Обслуговувати клієнтів", "Керувати персоналом"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to do a job'?",
                                    options = listOf("Виконувати роботу", "Купувати продукти", "Керувати компанією", "Надавати послуги"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to manage'?",
                                    options = listOf("Керувати", "Вчитися", "Грати", "Будувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to have a break'?",
                                    options = listOf("Мати перерву", "Заробляти гроші", "Відпочивати у відпустці", "Змінювати роботу"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'temporary situation'?",
                                    options = listOf("Тимчасова ситуація", "Робочий контракт", "Спеціальне завдання", "Грошова винагорода"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 3,
                    title = "Розділ 3",
                    topic = "Відпочинок",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to go to a market/a concert</b> – піти на ринок / концерт<br>\n" +
                                    "- <b>to go to a theatre/a museum/an art gallery</b> – піти в театр/музей/галерею мистецтв<br>\n" +
                                    "- <b>to see an exhibition/a band</b> – оглядати виставку / слухати гурт<br>\n" +
                                    "- <b>a comedy show</b> – комедійне шоу<br>\n" +
                                    "- <b>to get the bus</b> – сісти на автобус<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to go to a market/a concert'?",
                                    options = listOf("Піти на ринок / концерт", "Відвідати лікаря", "Подорожувати по світу", "Зустрічатися з друзями"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go to a theatre/a museum/an art gallery'?",
                                    options = listOf("Піти на стадіон", "Піти в театр/музей/галерею мистецтв", "Сходити в магазин", "Відвідати лікаря"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to see an exhibition/a band'?",
                                    options = listOf("Оглядати виставку / слухати гурт", "Дивитися серіал", "Займатися спортом", "Читати книжку"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'a comedy show'?",
                                    options = listOf("Музичний фестиваль", "Комедійне шоу", "Документальний фільм", "Драматична вистава"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to get the bus'?",
                                    options = listOf("Сісти на автобус", "Купити квиток", "Зустріти друга", "Піти на роботу"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to get a snack</b> – перекусити<br>\n" +
                                    "- <b>to go sightseeing</b> – оглядати визначні місця<br>\n" +
                                    "- <b>to go dancing</b> – танцювати<br>\n" +
                                    "- <b>to have a free meal</b> – безкоштовно обідати / вечеряти<br>\n" +
                                    "- <b>to have a drink</b> – випити чогось<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to get a snack'?",
                                    options = listOf("Замовити вечерю", "Перекусити", "Купити обід", "Готувати їжу"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go sightseeing'?",
                                    options = listOf("Оглядати визначні місця", "Їхати в таксі", "Йти в музей", "Грати в теніс"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go dancing'?",
                                    options = listOf("Піти в кіно", "Танцювати", "Читати книжку", "Зустрічатися з друзями"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to have a free meal'?",
                                    options = listOf("Безкоштовно обідати / вечеряти", "Запросити друзів", "Замовити страву", "Готувати вдома"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to have a drink'?",
                                    options = listOf("Піти в спортзал", "Готувати коктейлі", "Випити чогось", "Купити квиток"),
                                    correctAnswerIndex = 2
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 4,
                    title = "Розділ 4",
                    topic = "Видатні розуми",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to make a speech</b> – виступати з промовою<br>\n" +
                                    "- <b>to make friends</b> – подружитися<br>\n" +
                                    "- <b>to make a phone call</b> – телефонувати<br>\n" +
                                    "- <b>to make a terrible mistake</b> – зробити жахливу помилку<br>\n" +
                                    "- <b>to make a difficult decision</b> – прийняти складне рішення<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to make a speech'?",
                                    options = listOf("Записати відео", "Виступати з промовою", "Робити фото", "Вести переговори"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to make friends'?",
                                    options = listOf("Подружитися", "Відвідати концерт", "Подорожувати", "Відпочивати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to make a phone call'?",
                                    options = listOf("Телефонувати", "Перевірити електронну пошту", "Надіслати SMS", "Змінити налаштування"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to make a terrible mistake'?",
                                    options = listOf("Отримати нагороду", "Зробити жахливу помилку", "Знайти вихід", "Прийняти рішення"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to make a difficult decision'?",
                                    options = listOf("Прийняти складне рішення", "Відкласти на потім", "Обговорити з друзями", "Відмовитися"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to do a project</b> – працювати над проєктом<br>\n" +
                                    "- <b>to do a sport</b> – займатися спортом<br>\n" +
                                    "- <b>to do business</b> – вести бізнес<br>\n" +
                                    "- <b>to do well/badly</b> – мати хороші / погані результати<br>\n" +
                                    "- <b>to do one's homework</b> – виконувати домашнє завдання<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to do a project'?",
                                    options = listOf("Будувати дім", "Працювати над проєктом", "Вести переговори", "Читати книжку"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to do a sport'?",
                                    options = listOf("Дивитися спорт", "Займатися спортом", "Писати статтю", "Слухати музику"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 5,
                    title = "Розділ 5",
                    topic = "Подорожі",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>fence</b> – паркан / огорожа<br>\n" +
                                    "- <b>crash</b> – аварія / удар при зіткненні<br>\n" +
                                    "- <b>oxygen</b> – кисень<br>\n" +
                                    "- <b>to feel sick</b> – почуватись слабким, хворим<br>\n" +
                                    "- <b>to go for a drink</b> – посидіти в барі / піти щось випити<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'fence'?",
                                    options = listOf("Дорога", "Паркан / огорожа", "Міст", "Підвал"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'crash'?",
                                    options = listOf("Поломка", "Аварія / удар при зіткненні", "Підйом", "Затримка"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'oxygen'?",
                                    options = listOf("Вода", "Кисень", "Повітря", "Вуглець"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to feel sick'?",
                                    options = listOf("Почуватись слабким, хворим", "Працювати", "Почуватися щасливим", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go for a drink'?",
                                    options = listOf("Зайти в магазин", "Посидіти в барі / піти щось випити", "Відпочивати на пляжі", "Купувати продукти"),
                                    correctAnswerIndex = 1
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to deal with a problem</b> – вирішувати проблему<br>\n" +
                                    "- <b>to make a call</b> – телефонувати<br>\n" +
                                    "- <b>to get hungry</b> – зголодніти<br>\n" +
                                    "- <b>to fall asleep</b> – заснути<br>\n" +
                                    "- <b>to check one's voicemail</b> – перевірити голосову пошту<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to deal with a problem'?",
                                    options = listOf("Вирішувати проблему", "Відкладати справи", "Розважатися", "Подорожувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to make a call'?",
                                    options = listOf("Надіслати повідомлення", "Телефонувати", "Відправити лист", "Запросити друга"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to get hungry'?",
                                    options = listOf("Зголодніти", "Напитися", "Заснути", "Піти на прогулянку"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to fall asleep'?",
                                    options = listOf("Проснутися", "Заснути", "Зустрітися з друзями", "Подорожувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to check one's voicemail'?",
                                    options = listOf("Перевірити голосову пошту", "Записати повідомлення", "Піти на концерт", "Купити телефон"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 6,
                    title = "Розділ 6",
                    topic = "Фітнес і здоров'я",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>walking</b> – прогулянка пішки<br>\n" +
                                    "- <b>junk food</b> – нездорова їжа<br>\n" +
                                    "- <b>fizzy drinks</b> – газовані напої<br>\n" +
                                    "- <b>worrying</b> – хвилювання<br>\n" +
                                    "- <b>city life</b> – життя в місті<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'walking'?",
                                    options = listOf("Прогулянка пішки", "Біг", "Їзда на велосипеді", "Плавання"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'junk food'?",
                                    options = listOf("Здорова їжа", "Нездорова їжа", "Фрукти", "Овочі"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'fizzy drinks'?",
                                    options = listOf("Газовані напої", "Чай", "Кава", "Вода"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'worrying'?",
                                    options = listOf("Хвилювання", "Відпочинок", "Робота", "Здоров'я"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'city life'?",
                                    options = listOf("Життя в місті", "Життя на селі", "Подорожі", "Робота"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to miss breakfast</b> – не снідати зранку<br>\n" +
                                    "- <b>exercise</b> – фізичні вправи<br>\n" +
                                    "- <b>caffeine</b> – кофеїн<br>\n" +
                                    "- <b>oily fish</b> – жирна риба<br>\n" +
                                    "- <b>frozen food</b> – заморожена їжа<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to miss breakfast'?",
                                    options = listOf("Не снідати зранку", "Їсти сніданок", "Пити каву", "Готувати їжу"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'exercise'?",
                                    options = listOf("Фізичні вправи", "Навчання", "Робота", "Подорожі"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'caffeine'?",
                                    options = listOf("Кофеїн", "Чай", "Цукор", "Сіль"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'oily fish'?",
                                    options = listOf("Жирна риба", "Морепродукти", "Зелень", "Солодощі"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'frozen food'?",
                                    options = listOf("Заморожена їжа", "Свіжі овочі", "Домашня їжа", "Фаст-фуд"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 7,
                    title = "Розділ 7",
                    topic = "Зміни",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to look for</b> – шукати<br>\n" +
                                    "- <b>to dream about</b> – мріяти про<br>\n" +
                                    "- <b>to give up</b> – припинити щось / кинути (курити)<br>\n" +
                                    "- <b>to travel around</b> – подорожувати навколо<br>\n" +
                                    "- <b>to move to</b> – переїхати до<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to look for'?",
                                    options = listOf("Шукати", "Знайти", "Переглядати", "Слухати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to dream about'?",
                                    options = listOf("Думати про", "Мріяти про", "Говорити про", "Запитати про"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to give up'?",
                                    options = listOf("Кинути", "Продовжити", "Змінити", "Розпочати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to travel around'?",
                                    options = listOf("Подорожувати навколо", "Їхати на роботу", "Переїхати", "Піти в магазин"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to move to'?",
                                    options = listOf("Переїхати до", "Залишитись", "Повернутись", "Запізнитись"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to think about</b> – думати про<br>\n" +
                                    "- <b>to go back to</b> – повернутись до<br>\n" +
                                    "- <b>to wait for</b> – чекати на<br>\n" +
                                    "- <b>to be afraid of</b> – боятись чогось<br>\n" +
                                    "- <b>to get tired</b> – втомитися<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to think about'?",
                                    options = listOf("Думати про", "Говорити про", "Запитати про", "Слухати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to go back to'?",
                                    options = listOf("Повернутись до", "Залишитись", "Змінити", "Запізнитись"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to wait for'?",
                                    options = listOf("Чекати на", "Поспішати", "Пропускати", "Залишати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to be afraid of'?",
                                    options = listOf("Боятись чогось", "Гордитись", "Засмучуватись", "Злитися"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to get tired'?",
                                    options = listOf("Втомитися", "Зрадіти", "Засмутитись", "Подивуватись"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 8,
                    title = "Розділ 8",
                    topic = "Гроші",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>cash</b> – готівка<br>\n" +
                                    "- <b>credit card</b> – кредитна картка<br>\n" +
                                    "- <b>to lend</b> – давати гроші в позику<br>\n" +
                                    "- <b>to borrow</b> – позичати гроші<br>\n" +
                                    "- <b>note</b> – банкнота<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'cash'?",
                                    options = listOf("Готівка", "Кредит", "Відсотки", "Борг"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'credit card'?",
                                    options = listOf("Кредитна картка", "Готівка", "Кредит", "Розстрочка"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to lend'?",
                                    options = listOf("Давати гроші в позику", "Позичати гроші", "Заробляти гроші", "Зберігати гроші"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to borrow'?",
                                    options = listOf("Позичати гроші", "Отримувати подарунок", "Купувати акції", "Заробляти гроші"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'note'?",
                                    options = listOf("Банкнота", "Монета", "Кредит", "Квитанція"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>coin</b> – монета<br>\n" +
                                    "- <b>to tip</b> – залишати чайові<br>\n" +
                                    "- <b>to earn money</b> – заробляти гроші<br>\n" +
                                    "- <b>to invest money in</b> – вкладати гроші в<br>\n" +
                                    "- <b>to pay the bills</b> – оплачувати рахунки<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'coin'?",
                                    options = listOf("Монета", "Банкнота", "Чек", "Валюта"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to tip'?",
                                    options = listOf("Залишати чайові", "Позичати гроші", "Заробляти гроші", "Зберігати гроші"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to earn money'?",
                                    options = listOf("Заробляти гроші", "Витрачати гроші", "Зберігати гроші", "Позичати гроші"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to invest money in'?",
                                    options = listOf("Вкладати гроші в", "Позичати гроші", "Витрачати гроші", "Зберігати гроші"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to pay the bills'?",
                                    options = listOf("Оплачувати рахунки", "Купувати акції", "Брати кредит", "Зберігати гроші"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 9,
                    title = "Розділ 9",
                    topic = "Природа",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>desert</b> – пустеля<br>\n" +
                                    "- <b>waterfall</b> – водоспад<br>\n" +
                                    "- <b>mountain range</b> – гірський хребет<br>\n" +
                                    "- <b>rain forest</b> – дощовий ліс<br>\n" +
                                    "- <b>to be in trouble</b> – бути в халепі<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'desert'?",
                                    options = listOf("Озеро", "Гора", "Пустеля", "Річка"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'waterfall'?",
                                    options = listOf("Ліс", "Водоспад", "Море", "Гірський хребет"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'mountain range'?",
                                    options = listOf("Гірський хребет", "Луг", "Річка", "Скеля"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'rain forest'?",
                                    options = listOf("Пустеля", "Річка", "Дощовий ліс", "Озеро"),
                                    correctAnswerIndex = 2
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to be in trouble'?",
                                    options = listOf("Бути в халепі", "Бути щасливим", "Бути в дорозі", "Засмагати"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to destroy</b> – зруйнувати<br>\n" +
                                    "- <b>to become extinct</b> – вимерти<br>\n" +
                                    "- <b>to melt</b> – танути<br>\n" +
                                    "- <b>sea level</b> – рівень моря<br>\n" +
                                    "- <b>species</b> – вид<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to destroy'?",
                                    options = listOf("Зруйнувати", "Будувати", "Захищати", "Вирощувати"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to become extinct'?",
                                    options = listOf("Заснути", "Вимерти", "Захворіти", "Зникнути"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to melt'?",
                                    options = listOf("Замерзати", "Танути", "Грітися", "Замочувати"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'sea level'?",
                                    options = listOf("Глибина океану", "Рівень моря", "Температура води", "Соляний склад"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'species'?",
                                    options = listOf("Клімат", "Вид", "Тварина", "Рослина"),
                                    correctAnswerIndex = 1
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 10,
                    title = "Розділ 10",
                    topic = "Суспільство",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>public transport</b> – громадський транспорт<br>\n" +
                                    "- <b>to sit outside</b> – посидіти надворі<br>\n" +
                                    "- <b>nightlife</b> – нічне життя<br>\n" +
                                    "- <b>local food</b> – місцева їжа<br>\n" +
                                    "- <b>crowded streets</b> – залюднені вулиці<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'public transport'?",
                                    options = listOf("Громадський транспорт", "Автомобільний рух", "Пішохідні зони", "Метро"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to sit outside'?",
                                    options = listOf("Посидіти надворі", "Грати в теніс", "Читати книжку", "Відвідувати концерт"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'nightlife'?",
                                    options = listOf("Нічне життя", "Ранкові прогулянки", "Денні подорожі", "Вечірні новини"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'local food'?",
                                    options = listOf("Місцева їжа", "Фаст-фуд", "Ресторанна кухня", "Дієтичне харчування"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'crowded streets'?",
                                    options = listOf("Залюднені вулиці", "Тихі провулки", "Порожні дороги", "Затишні парки"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>graffiti</b> – графіті<br>\n" +
                                    "- <b>murder</b> – вбивство<br>\n" +
                                    "- <b>drink driving</b> – кермування автомобілем у нетверезому стані<br>\n" +
                                    "- <b>credit card fraud</b> – шахрайство з кредитними картками<br>\n" +
                                    "- <b>speeding</b> – перевищення швидкості<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'graffiti'?",
                                    options = listOf("Графіті", "Архітектура", "Пам’ятки культури", "Фреска"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'murder'?",
                                    options = listOf("Крадіжка", "Вбивство", "Підпал", "Шахрайство"),
                                    correctAnswerIndex = 1
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'drink driving'?",
                                    options = listOf("Кермування автомобілем у нетверезому стані", "Паркування у забороненому місці", "Ремонт автомобіля", "Дорожній контроль"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'credit card fraud'?",
                                    options = listOf("Шахрайство з кредитними картками", "Банківський переказ", "Оренда житла", "Оплата рахунків"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'speeding'?",
                                    options = listOf("Перевищення швидкості", "Безпечне водіння", "Перевезення вантажу", "Перевірка документів"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),
                Lesson(
                    id = 11,
                    title = "Розділ 11",
                    topic = "Технології",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>to use your mobile</b> – користуватися своїм мобільним телефоном<br>\n" +
                                    "- <b>to write a blog</b> – писати блог<br>\n" +
                                    "- <b>to send a fax</b> – висилати факс<br>\n" +
                                    "- <b>to check your email</b> – перевіряти свою електронну пошту<br>\n" +
                                    "- <b>to send a text message</b> – надсилати текстове повідомлення<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to use your mobile'?",
                                    options = listOf("Користуватися своїм мобільним телефоном", "Залишити телефон вдома", "Вимкнути телефон", "Перевірити акаунт"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to write a blog'?",
                                    options = listOf("Писати блог", "Читати газету", "Дивитися новини", "Редагувати статтю"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to send a fax'?",
                                    options = listOf("Висилати факс", "Відправити email", "Роздрукувати документ", "Написати повідомлення"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to check your email'?",
                                    options = listOf("Перевіряти свою електронну пошту", "Відправити лист", "Отримати повідомлення", "Купити телефон"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to send a text message'?",
                                    options = listOf("Надсилати текстове повідомлення", "Видалити контакт", "Змінити налаштування", "Отримати дзвінок"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>to chat online</b> – спілкуватися онлайн<br>\n" +
                                    "- <b>to update your webpage</b> – оновлювати веб-сторінку<br>\n" +
                                    "- <b>to use an internet call</b> – користуватись дзвінком через інтернет<br>\n" +
                                    "- <b>social networking sites</b> – соціальні мережі<br>\n" +
                                    "- <b>to text someone</b> – писати комусь SMS<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'to chat online'?",
                                    options = listOf("Спілкуватися онлайн", "Грати в онлайн-ігри", "Дивитися фільми", "Завантажувати файли"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to update your webpage'?",
                                    options = listOf("Оновлювати веб-сторінку", "Створювати сайт", "Видаляти акаунт", "Купувати рекламу"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to use an internet call'?",
                                    options = listOf("Користуватись дзвінком через інтернет", "Купити новий телефон", "Видалити контакт", "Змінити тариф"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'social networking sites'?",
                                    options = listOf("Соціальні мережі", "Новинні портали", "Мобільні додатки", "Музичні сервіси"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to text someone'?",
                                    options = listOf("Писати комусь SMS", "Зателефонувати", "Відправити email", "Видалити повідомлення"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                ),

                Lesson(
                    id = 12,
                    title = "Розділ 12",
                    topic = "Слава та знаменитості",
                    stages = listOf(
                        LessonStage.Content(
                            text = "<b>Слова та їх значення:</b><br>\n" +
                                    "- <b>action film</b> – бойовик<br>\n" +
                                    "- <b>comedy</b> – комедія<br>\n" +
                                    "- <b>fantasy film</b> – фентезі<br>\n" +
                                    "- <b>science fiction film</b> – наукова фантастика<br>\n" +
                                    "- <b>drama</b> – драма<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'action film'?",
                                    options = listOf("Бойовик", "Комедія", "Фентезі", "Документальний фільм"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'comedy'?",
                                    options = listOf("Комедія", "Трилер", "Мюзикл", "Драма"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'fantasy film'?",
                                    options = listOf("Фентезі", "Жахи", "Мультфільм", "Романтичний фільм"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'science fiction film'?",
                                    options = listOf("Наукова фантастика", "Вестерн", "Документальний фільм", "Комедія"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'drama'?",
                                    options = listOf("Драма", "Мюзикл", "Фантастика", "Трилер"),
                                    correctAnswerIndex = 0
                                )
                            )
                        ),
                        LessonStage.Content(
                            text = "<b>Наступні слова:</b><br>\n" +
                                    "- <b>celebrity</b> – знаменитість<br>\n" +
                                    "- <b>embarrassing video</b> – конфузне відео<br>\n" +
                                    "- <b>inventor</b> – винахідник<br>\n" +
                                    "- <b>scientist</b> – науковець<br>\n" +
                                    "- <b>to dedicate</b> – присвятити<br>\n"
                        ),
                        LessonStage.MultipleQuiz(
                            quizzes = listOf(
                                QuizBlock(
                                    question = "Як перекласти 'celebrity'?",
                                    options = listOf("Знаменитість", "Вчений", "Дизайнер", "Спортсмен"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'embarrassing video'?",
                                    options = listOf("Конфузне відео", "Музичний кліп", "Реклама", "Фільм"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'inventor'?",
                                    options = listOf("Винахідник", "Письменник", "Актор", "Співак"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'scientist'?",
                                    options = listOf("Науковець", "Художник", "Журналіст", "Архітектор"),
                                    correctAnswerIndex = 0
                                ),
                                QuizBlock(
                                    question = "Як перекласти 'to dedicate'?",
                                    options = listOf("Присвятити", "Забути", "Відкласти", "Змінити"),
                                    correctAnswerIndex = 0
                                )
                            )
                        )
                    )
                )
            ),
            imageResId = R.drawable.ic_words_a2
        )
    )
}
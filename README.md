# OOP_Java
 All projects created during an object-oriented programming class.

# Calculator

Zadanie 1
Dodaj brakujące testy dla operacji dodawania i mnożenia. Pomyśl o testach na krańcach dziedziny.

Zadanie 2
Dodaj do kalkulatora dwie nowe operacje wraz z testami. Najmniej jedna z operacji powinna posiadać jakieś wykluczenia z dziedziny, np. opracja dzielenia i dzielenie przez 0.

Zadanie 3
Dodaj do kalkulatora możliwość przechowywania wyniku w pamięci oraz wykonywania operacji z wykorzystaniem danych przechowywanych w pamięci.

# Stos

Zadanie 1 (Red)
W pliku StackTest.java wpisać brakujące testy dla opracji na stosie przedstawionych w pliku Stack.java. Wymagania:

- push wkłada jeden element na stos
- pop zdejmuje jeden element ze stosu i oddaje wartość tego elementu; co się ma dziać gdy pop próbuje zdjąc element z pustego stosu
- peek podobnie jak pop oddaje wartość elementu na szczycie stosu ale go nie zdejmuje; podobny problem z pustym stosem co w przypadku pop

Zadanie 2 (Green)
Zaimplementuj testy z zadania 1. Nośnik danych w stosie powinien być tablicą elementów typu int. Jak sobie poradzić we skończonością tablicy? Stos powinien działać na dowolnej liczbie elementów.

# Koszyk

Twoja firma dostała zlecenie na stworzenie oprogramowania dla dużego sklepu internetowego *JavaMarkt*. 
Jedną z podstawowych funkcjonalności będzie oprogramowanie koszyka zakupów, 
który potrafiłby uwzględniać różne promocje, rabaty oraz oferty specjalne, takie jak:
- jeśli wartość zamówienia jest większa niż 300 zł klient otrzymuje 5% zniżki na zakupione towary
- jeśli klient kupi 2 produkty to 3 najtańszy otrzymuje gratis
- jeśli wartość zamówienia przekracza wartość 200 zł klient otrzymuje firmowy kubek gratis
- jednorazowy kupon rabatowy 30% na wybrany produkt
oraz wiele innych jeszcze nieznanych na tym etapie implementacji.

Towary w koszyku powinny być posegregowane malejąco według ceny, 
a potem według kolejności alfabetycznej nazw produktów.

Twoim zadaniem jest zaimplementowanie logiki, operującej na obiektach typu ``Product``, 
która umożliwiałaby:
1. Wyszukiwanie najtańszego/najdroższego produktu w zadanej kolekcji produktów
2. Wyszukiwanie n najtańszych/najdrożyszych produktów w zadanej kolekcji produktów
3. Sortowanie kolekcji produktów po cenie jak i po nazwie
4. Wyliczanie sumy cen wszystkich zadanych produktów
5. Wyświetlanie w konsoli informacji o wszystkich produktach w zadanej kolekcji produktów
6. Aplikowanie opisanych powyżej rodzajów promocji na zadanej kolekcji produktów

Specyfikacja klasy ``Product``:
- pola w klasie:
    - kod produktu (code) - String
    - nazwa produktu (name) - String
    - cena produktu (price) – double
    - cena produktu po uwzględnieniu promocji (discountPrice) - double

W tym zadaniu użyj tablicy produktów jako kolekcji, na której będziesz operował.

### Uwaga
Projekt powinien również zawierać odpowiednie testy jednostkowe do implementowanej funkcjonalności.

# Pracownicy

Napisz program który reprezentował będzie rejestr pracowników w jednej ze światowych korporacji. 
Jako wytyczną przyjmij fakt, iż korporacja charakteryzuje się 
trzema podstawowymi typami zatrudnionych pracowników:
- **Pracownik biurowy**: charakteryzuje się następującymi cechami istotnymi dla korporacji:
    - identyfikator pracownika: unikalny dla każdego pracownika w obrębie całej korporacji
    - imię
    - nazwisko
    - wiek
    - doświadczenie
    - adres budynku w którym pracuje: adres powinien składać się z czterech elementów:
        - nazwy ulicy 
        - numeru budynku 
        - numeru lokalu 
        - nazwy miasta
    - identyfikator stanowiska biurowego: unikalny w skali całej korporacji
    - intelekt: wyrażony w iq w skali 70 - 150

- **Pracownik fizyczny**: charakteryzuje się następującymi cechami istotnymi dla korporacji:
    - identyfikator pracownika: unikalny dla każdego pracownika w obrębie całej korporacji
    - imię
    - nazwisko
    - wiek
    - doświadczenie
    - adres budynku w którym pracuje: adres powinien składać się z czterech elementów:
        - nazwy ulicy 
        - numeru budynku 
        - numeru lokalu 
        - nazwy miasta
    - siła fizyczna - wyrażona w skali od 1 - 100

- **Handlarz**: charakteryzuje się następującymi cechami istotnymi dla korporacji:
    - identyfikator pracownika: unikalny dla każdego pracownika w obrębie całej korporacji
    - imię
    - nazwisko
    - wiek
    - doświadczenie
    - adres budynku w którym pracuje: adres powinien składać się z czterech elementów:
        - nazwy ulicy 
        - numeru budynku 
        - numeru lokalu 
        - nazwy miasta
    - skuteczność: wyrażona w trzech stałych typach ``NISKA``, ``ŚREDNIA``, ``WYSOKA`` 
    - wysokość prowizji: wyrażona w procentach

Rejestr powinien umożliwić realizację następujących zadań:
- dodanie dowolnego z typów pracownika do rejestru
- usunięcie pracownika o danym identyfikatorze pracowniczym z rejestru
- dodanie kilku pracowników o różnych typach na raz do rejestru
- wyświetlenie listy wszystkich pracowników posortowanych po liczbie lat doświadczenia (malejąco)
- wyświetlenie listy wszystkich pracowników posortowanych po wieku pracownika (rosnąco)
- wyświetlenie listy wszystkich pracowników posortowanych po nazwisku pracownika (zgodnie z kolejnością alfabetyczną)
- wyświetlenie listy pracowników, którzy pracują w mieście po nazwie podanej 
 jako parametr wejściowy
- wyświetlenie listy wszystkich pracowników wraz  z ich wartością dla korporacji, 
 przy czym dla każdego z typów pracownika stopień wartości obliczany jest w inny sposób:
    - dla pracownika biurowego: wartość dla korporacji obliczana jest 
    ze wzoru: ``doświadczenie * intelekt``
    - dla pracownika fizycznego: wartość dla korporacji obliczana jest 
    ze wzoru ``doświadczenie * siła / wiek``
    - dla handlowca: wartość dla korporacji obliczana jest 
    ze wzoru ``doświadczenie * skuteczność``, 
    gdzie odpowiedni typ skuteczności zamieniany jest na wartość
        - ``NISKA``: 60
        - ``ŚREDNIA``: 90
        - ``WYSOKA``: 120

Zastanów się w jaki sposób zamodelować obiekt pracownika w programie, 
zważywszy na to, że spora ilość cech jest wspólna dla każdego z poszczególnych typów pracownika. 
Wszystkie obiekty rejestru przechowuje w pamięci komputera w wybranej przez Ciebie kolekcji 
(Zastanów się która z kolekcji będzie najlepiej realizować zadania związane z rejestrem pracowników).

---

W zadaniu oceniane będą:
- Tworzenie klas: 20%
- Kompozycja: 10%
- Dziedziczenie: 20 %
- Implementacje interfejsów (Comparator): 20%
- Praca z kolekcjami: 20%
- Polimorfizm: 10%

### Uwaga
Projekt powinien również zawierać odpowiednie testy jednostkowe do implementowanej funkcjonalności.

# Świat

### Zadania
1. **[3 punkty]** Zrealizować w języku Java świat wg opisu w podkatalogach:
   `World01`, `World02`, `World03` oraz `World04` znajdujących się pod adresem:
   `https://github.com/tborzyszkowski/PythonWorld/tree/master/Laboratorium`.
   Katalogi zawierają przykładową implementację w Pythonie. 
   Udoskonalić przedstawioną tam implementację, 
   stosując koncepcje programowania obiektowego dostępne w Java 
   oraz odpowiednie wzorce projektowe (najmniej dwa, np. fabrykę, obserwator, odwiedzający, ...).
   
1. **[2 punkty]** Do świata dodać nowy organizm, kosmitę. Kosmita porusza się 
   o jedno pole jak król w szachach. Sam kosmita jest niewidzialny dla pozostałych 
   organizmów.
    Jego pojawienie się na danym polu powoduje, 
   że w odległości dwóch pól *zatrzymuje się czas*. 
   Kosmita pojawia się w świecie spontanicznie i także spontanicznie znika. 
   
1. **[2 punkty]** Zbalansować reguły rządzące światem, tak by żaden gatunek nie wyginął 
    i dodatkowo by świat nie został zdominowany przez jeden gatunek.
   
1. **[2 punkty]** Program wyposażyć w testy sprawdzające interakcje organizmów.

1. **[1 punktów]** Program powinien posiadać interfejs (tekstowy lub graficzny) pozwalający obserwować
    rozwój świata w kolejnych turach.

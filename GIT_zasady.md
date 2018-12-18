# Zasady kodowania
* Nazwy klas, metod, zmiennych - po angielsku, camelCase, nazwy znaczące!
* Sprawdzanie kodu przez Inspect code, CheckStyle, SonarLint
* TESTY!!! Pokrycie ma być 80% - pisać w TDD, wiele to ułatwi. Minimum to testowanie już napisanych funkcjonalności, może to być z Mockowaniem jak trzeba, ale pokrycie musi być do akceptacji migawki.


# Zadania i komunikacja
* Każde zadanie przydzielone do konkretnej osoby
* Estymaty do zadania - czas wykonania (realistyczny, pesymistyczny, optymistyczny) - na kiedy dowieziemy funkcjonalność
* Zapisane w treści zadania jakie testy wymagane do sprawdzenia czy dowiezione (ewentualnie jak sprawdzić czy dobrze działa)
* Komentować w zadaniu ukończone części składowe - żeby łatwo się zorientować, na jakim etapie jest praca
* Każde zadanie ma swoją gałąź
* Programowanie w parach - ocena na bieżąco swojego kodu i rozmowy o kodzie, nie piszcie sami całego zadania bez konsultacji z drugą osobą, bo później łatwo się zamotać
* Tomek na demie wymaga, żeby wszyscy wiedzieli o wszystkim - piszcie w komentarzu do zadania, dlaczego coś jest rozwiązane tak, a nie inaczej - róbmy sobie dema po całym dniu tego co zrobiliśmy i pytajmy


# Migawki
* Dobre opisy migawek! Pierwsza linijka - jaka funkcjonalność dodana, druga linijka: dlaczego/w jakim celu. Nie opisujcie tylko tego, co jest zawarte w kodzie.
* Testy muszą przechodzić - zainstalować git hook (Michał?) który będzie to sprawdzał i nie puści migawki z czerwonym testem
* mvn clean install przy migawce? może w skrypcie git hook? na pewno kończąc zadanie
* Spłaszczać podobne migawki na bieżąco czy po zakończeniu zadania wszystkie? do ustalenia

# Gałęzie
* święty majster
* nazywanie gałęzi: numer zadania + nazwa zadania z Waffle'a (może być skrócona), np. 17-aplikacja-klienta
* jedna gałąź na funkcjonalność
* rozwój kodu na devie i pull requesty do deva, przed devem nalezy
- rozwiązac ewentualne konflikty
- użyć narzędzia do sprawdzenia jakości kodu (sonar itd.)
- odpalić testy
- odpalić mvn clean install
* przed demo scalenie deva do majstra z jakimś releasem (etykieta?)

# Scalanie

# Demo
* sprawdzana tablica zadań - kamienie milowe - które mają być do dowiezienia na demo. Jak nie ma kamieni milowych, to domyślnie cała tablica miała być dowieziona
* Ustalenie czy patrzymy na estymaty pesymistyczne, realistyczne czy optymistyczne
* Instalacja aplikacji na serwerze docelowym - z Jenkinsa lub ręcznie
* Pytania o serwer (jaki, jakie parametry, jak zabezpieczony...)
* Pytania z używanych bibliotek, w tym ze Swinga/JavyFX
* wewnętrzne demo dzień przed prawdziwym demem 

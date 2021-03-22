# PA_Lab5
Am comentat partea din main care apeleaza exemplul din compulsory, acum ruleaza doar shell-ul.
Am facut tot din partea de Optional, mai putin comanda report cu raportul html.
Comenzile se afla in clasa Commands, acolo am clasa Command care este abstracta,aceasta contine variabila arguments si metoda abstracta execute;
celelalte comenzi sunt extinderi ale acelei clase, acestea dau doar throw la exceptii.
In clasa Shell, metoda analyzeCommand, analizeaza inputul de la user si apeleaza clasa corespunzatoare, tot in aceasta metoda se face catch la throw-urile
din comenzi. Shell-ul nu se inchide atunci cand primeste o eroare, doar o afiseaza si trece mai departe.
JAR-ul este facut, se afla in folderul out/artifacts/..

Comenzile folosite de shell:
Comenzi posibile : 'add' 'list' 'load' 'play' 'quit' 'report'
-- add : add TYPE[MOVIE|IMAGE] NAME[STRING] PATH[STRING]
-- play: play : da play la itemele din catalog 
         play path[STRING]: da play la acel path 
-- load: load path[STRING]
-- save : save
-- list : list 
-- report: report //neimplementata

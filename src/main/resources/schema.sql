DROP TABLE IF EXISTS noticia;
DROP TABLE IF EXISTS manga;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS usuario;

CREATE TABLE manga (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE perfil (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NUll,
    perfil_id INT NOT NULL,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

CREATE TABLE usuario_manga (
    usuario_id INT NOT NULL,
    manga_id INT NOT NULL,
    PRIMARY KEY (usuario_id, manga_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (manga_id) REFERENCES manga(id)
);

CREATE TABLE noticia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    corpo VARCHAR(2000) NOT NULL,
    dataLancamento DATE NOT NULL,
    visualizacoes INT DEFAULT 0,
    urlImagem VARCHAR(300),
    manga_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (manga_id) REFERENCES manga(id),
    FOREIGN KEY (user_id) REFERENCES usuario(id)
);

INSERT INTO manga(nome)
    VALUES ('testeNomeManga1'), ('testeNomeManga2');

INSERT INTO perfil(id, nome)
    VALUES (1, 'ADMIN'), (2, 'CLIENTE');

INSERT INTO usuario(nome, email, senha, perfil_id)
    VALUES ('Admin', 'admin@admin', 'admin', 1), ('Leonardo Rocha', 'leonardo.rocha@gmail.com', 'leo', 2);

INSERT INTO usuario_manga VALUES (2, 2);

INSERT INTO noticia(titulo, corpo, dataLancamento, visualizacoes, urlImagem, manga_id, user_id)
    VALUES
    ('Beastars – Mangá irá finalizar nos próximos 3 capítulos',
    'A 43ª edição deste ano da revista Weekly Shonen Champion revelou que o mangá Beastars de Paru Itagaki terminará em três capítulos. Se não houver pausa, o mangá terminará portanto em outubro. Itagaki postou uma ilustração no Twitter para o anúncio. Além disso, a revista também revelou que Yuuki Kaji fará a voz do personagem Pina na segunda temporada do anime.',
    '2020-10-6', 10,
    'https://animenew.com.br/wp-content/uploads/2020/10/Funouhan-Manga-encerra-em-Novembro-696x348.jpg',
    2, 1),
    ('Miyamoto Sakura ga Kawaii Dake no Shousetsu no Manga – Fim do mangá',
    'A edição de novembro da Shonen Magazine Edge publicou enfim o capítulo final do mangá Miyamoto Sakura ga Kawaii Dake no Shousetsu no Manga. A Kodansha publicará o segundo volume do mangá no dia 17 de novembro. A história de Miyamoto Sakura ga Kawaii Dake no Shousetsu no Manga gira em torno da vida cotidiana de Hikaru Ougami e sua amiga de infância Sakura Miyamoto. O mangá foi lançado na Shonen Magazine Edge no dia 17 de janeiro no início deste ano. Kodansha publicou o primeiro volume em 17 de julho. O usuario Suzuki e o ilustrador Rurudo lançaram a série de Light Novel’s, com o primeiro volume sendo então lançado em fevereiro de 2019 e o quarto volume sendo publicado no dia 20 de Julho.',
    '2020-10-6', 20,
    'https://animenew.com.br/wp-content/uploads/2020/10/Miyamoto-Sakura-ga-Kawaii-Dake-no-Shousetsu-no-Manga-Fim-do-manga-696x348.jpg',
    1, 1),
    ('Mangá de One Piece sofrerá uma pausa devido à uma doença do usuario',
    'A conta oficial do Twitter do departamento editorial da revista Weekly Shonen Jump revelou então que o mangá One Piece não aparecerá na 44ª edição da revista como havia sido planejado. O departamento editorial explicou que o mangá está dando uma pausa devido à uma “doença repentina” do usuario Eiichiro Oda. A secretaria informou que a Oda está em recuperação e que o mangá voltará na 46ª edição da revista, que sairá portanto no dia 17 de outubro. One Piece também já sofreu atrasos devido ao COVID-19. Oda alertou em maio que mais atrasos são possíveis, pois sua equipe reorganizou o local de trabalho para facilitar o distanciamento social.',
    '2020-02-10',
    50,
    'https://animenew.com.br/wp-content/uploads/2020/10/Manga-de-One-Piece-sofrera-uma-pausa-devido-a-uma-doenca-do-usuario-696x348.jpg',
    2, 1),
    ('Dragon Quest: Adventure of Dai Cross Blade – Mangá chega em Outubro',
    'O usuario Yoshikazu Amami revelou por meio do seu Twitter que irá lançar o mangá Dragon Quest: Adventure of Dai Cross Blade na edição de novembro da revista Saikyo Jump, que será portanto lançada no dia 1 de outubro. Vale lembrar que o mangá Dragon Quest: Adventure of Dai também está inspirando um novo mangá na revista V Jump. A história do mangá será então centrada nas aventuras do personagem Avan antes de conhecer Dai e seus companheiros. Um novo anime baseado no mangá original será lançado a partir do dia 3 de outubro. Fonte: ANN',
    '2020-08-09',
    120,
    'https://animenew.com.br/wp-content/uploads/2020/09/Dragon-Quest-Adventure-of-Dai-Cross-Blade-Manga-chega-em-Outubro-696x348.jpg',
    1, 1),
    ('Teito Hatsukoi Shinjuu encerra em Novembro',
    'O Twitter oficial da revista Sho-Comi anunciou que o mangá Teito Hatsukoi Shinjuu terminará na edição de dezembro da revista Sho-ComiX no dia 15 de novembro. Teito Hatsukoi Shinjuu se passa na era Taisho, e acompanha a história de Kaori Yoshino, uma garota de 16 anos. Kaori se casa com o famoso Earl Tamaki Misono, de 20 anos, presidente da empresa rival de sua família. Embora seja um casamento arranjado, Kaori não consegue resistir ao amor de Misono. O mangá entrou então no seu último arco na edição da Sho-ComiX que foi lançada no dia 15 de maio. O 9º volume do mangá será portanto o volume final, e será lançado neste inverno. Fonte: ANN',
    '2020-02-09',
    40,
    'https://animenew.com.br/wp-content/uploads/2020/09/Teito-Hatsukoi-Shinjuu-encerra-em-Novembro-696x348.jpg',
    1, 1),
    ('Mangá Dead Dead Demon’s ganha curta em 3DCG',
    'O mangá Dead Dead Demon’s Dededede Destruction de Inio Asano ganhou um curta de 40s usando a tecnologia experimental 3DCG. O curta é uma parceria com a fabricante de computadores Mouse Computer, com patrocínio da marca “DAIV”, desenvolvida sob o conceito de “um PC para criadores, por criadores.”. O vídeo tem produção de Kohta Morie, que recentemente trabalhou no comercial “Hungry Days” da Nisshin Cup Noodles com os personagens de One Piece. Ademais, Asano tem usado o produto da marca há anos, assim o projeto foi realizado. Por fim, o slice of life de ficção cientifica Dead Dead Demon’s Dededede Destruction é serializado na Big Comics Spirits da Shogakukan desde abril de 2014, contando com 9 volumes até agora. Outrossim, Asano é o usuario do famoso mangá de drama Oyasumi Punpun 2007-2013. O mangá recebeu uma recomendação do júri no 13º Japan Media Arts Festival Awards e também foi nominado para o Eisner Award em 2017.',
    '2020-04-20',
    1020,
    'https://animenew.com.br/wp-content/uploads/2020/09/dead-dead-demons-3dcg-696x348.png',
    2, 1
    )
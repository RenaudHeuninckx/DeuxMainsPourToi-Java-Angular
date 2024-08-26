CREATE TABLE actualite
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)  NOT NULL,
    DescriptionCourte nvarchar(255) NOT NULL,
    URL               nvarchar(1024),
    URLonly           bit           NOT NULL,
    Rang              int           NOT NULL,
    Displayed         bit           NOT NULL
);

CREATE TABLE actualite_content
(
    Id          int AUTO_INCREMENT PRIMARY KEY,
    ActualiteId int            NOT NULL,
    Description nvarchar(2048) NOT NULL,
    Image       nvarchar(1024),
    Rang        int            NOT NULL,
    CONSTRAINT FK_actualite_content_actualite
        FOREIGN KEY (ActualiteId)
            REFERENCES actualite (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE espace_detente
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)   NOT NULL,
    DescriptionCourte nvarchar(255)  NOT NULL,
    Description       nvarchar(2048) NOT NULL,
    image             nvarchar(1024),
    Rang              int            NOT NULL
);

CREATE TABLE evenement
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)  NOT NULL,
    DescriptionCourte nvarchar(255) NOT NULL,
    Rang              int           NOT NULL,
    Displayed         bit           NOT NULL
);

CREATE TABLE evenement_content
(
    Id          int AUTO_INCREMENT PRIMARY KEY,
    EvenementId int            NOT NULL,
    Description nvarchar(2048) NOT NULL,
    Image       nvarchar(1024),
    Rang        int            NOT NULL,
    CONSTRAINT FK_evenement_content_evenement
        FOREIGN KEY (EvenementId)
            REFERENCES evenement (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE HomeContent
(
    Id        int AUTO_INCREMENT PRIMARY KEY,
    Categorie nvarchar(50) NOT NULL,
    ContentId int          NOT NULL,
    FromDate  date,
    ToDate    date,
    Rang      int          NOT NULL
);

CREATE TABLE massage
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)   NOT NULL,
    Type              nvarchar(50),
    DescriptionCourte nvarchar(255)  NOT NULL,
    Description       nvarchar(2048) NOT NULL,
    Duree             nvarchar(20)   NOT NULL,
    Prix              decimal(5,2)  NOT NULL,
    Image             nvarchar(1024),
    Displayed         bit            NOT NULL,
    Rang              int            NOT NULL
);

CREATE TABLE pack_offre
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)   NOT NULL,
    DescriptionCourte nvarchar(255)  NOT NULL,
    Description       nvarchar(2048) NOT NULL,
    prix              decimal(5,2)  NOT NULL,
    Image             nvarchar(1024)  NOT NULL,
    Rang              int            NOT NULL,
    Displayed         bit            NOT NULL
);

CREATE TABLE presse
(
    Id                int AUTO_INCREMENT PRIMARY KEY,
    Titre             nvarchar(128)  NOT NULL,
    DescriptionCourte nvarchar(255) NOT NULL,
    URL               nvarchar(1024),
    Rang              int           NOT NULL,
    Displayed         bit           NOT NULL
);

CREATE TABLE utilisateur
(
    Id           int AUTO_INCREMENT PRIMARY KEY,
    Pseudo       nvarchar(255)  NOT NULL,
    Email        nvarchar(1024) NOT NULL,
    Password     nvarchar(1024)  NOT NULL,
    Newsletter   bit            NOT NULL DEFAULT false,
    Admin        bit            NOT NULL DEFAULT false,
    CreatedDate  datetime       NOT NULL,
    ModifiedDate datetime       NOT NULL,
    DeletedDate  datetime
);

CREATE TABLE comment
(
    Id            int AUTO_INCREMENT PRIMARY KEY,
    UtilisateurId int            NOT NULL,
    Commentaire   nvarchar(2048) NOT NULL,
    ActualiteId   int,
    EvenementId   int,
    MassageId     int,
    PackOffreId   int,
    Creation_date datetime       NOT NULL,
    ModifiedDate  datetime       NOT NULL,
    DeletedDate   datetime,
    CONSTRAINT FK_comment_actualite
        FOREIGN KEY (ActualiteId)
            REFERENCES actualite (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT FK_comment_evenement
        FOREIGN KEY (EvenementId)
            REFERENCES evenement (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT FK_comment_massage
        FOREIGN KEY (MassageId)
            REFERENCES massage (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT FK_comment_pack_offre
        FOREIGN KEY (PackOffreId)
            REFERENCES pack_offre (Id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

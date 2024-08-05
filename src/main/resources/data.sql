CREATE TABLE _USER (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       isim VARCHAR(255) NOT NULL,
                       soyisim VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       telefon VARCHAR(255) NOT NULL,
                       cinsiyet VARCHAR(255) CHECK (cinsiyet IN ('ERKEK', 'KADIN')),
                       tcKimlikNo BIGINT,
                       akademikUnvan VARCHAR(255),
                       aracPlakasi VARCHAR(255),
                       acilDurumKisi VARCHAR(255),
                       acilDurumTelefon VARCHAR(255),
                       adres TEXT,
                       dogumTarihi DATE,
                       photo BLOB,
                       kanGrubu VARCHAR(255) CHECK (kanGrubu IN ('0+', '0-', 'A+', 'A-', 'B+', 'B-', 'AB+', 'AB-')),
                       accountNonExpired BOOLEAN DEFAULT TRUE,
                       accountNonLocked BOOLEAN DEFAULT TRUE,
                       credentialsNonExpired BOOLEAN DEFAULT TRUE,
                       enabled BOOLEAN DEFAULT TRUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ORGANIZATION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    top_org_id BIGINT,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (top_org_id) REFERENCES ORGANIZATION(id) ON DELETE CASCADE
);

CREATE TABLE KURUMSAL(
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        user_id BIGINT,
                        org_id BIGINT,
                        iseGirisTarihi DATE,
                        sicilNo BIGINT,
                        kadro VARCHAR(255),
                        unvan VARCHAR(255),
                        gorev VARCHAR(255),
                        persolenTuru VARCHAR(255) CHECK (persolenTuru IN ('YONETICI', 'CALISAN', 'STAJYER')),
                        calismaTuru VARCHAR(255) CHECK (calismaTuru IN ('TAM_ZAMANLI', 'YARI_ZAMANLI', 'SERBEST')),
                        calismaDurumu VARCHAR(255) CHECK (calismaDurumu IN ('AKTIF', 'PASIF', 'IZINLI')),
                        servisKullanimi BOOLEAN DEFAULT TRUE,
                        dahiliNumara VARCHAR(255),
                        odaNumara INT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                        FOREIGN KEY (org_id) REFERENCES ORGANIZATION(id) ON DELETE CASCADE
);

CREATE TABLE PROJE(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    projeAdi VARCHAR(255) NOT NULL,
    takim VARCHAR(255) NOT NULL,
    baslangicTarihi DATE NOT NULL,
    bitisTarihi DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE GOREV(
    user_id BIGINT,
    proje_id BIGINT,
    gorev VARCHAR(255),
    PRIMARY KEY (user_id, proje_id),
    FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
    FOREIGN KEY (proje_id) REFERENCES PROJE(id) ON DELETE CASCADE
);

CREATE TABLE KATKI (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       etkinlikTuru VARCHAR(255) NOT NULL CHECK (etkinlikTuru IN ('EGITIM', 'YAYINLAR_ARAŞTIRMA_SERİSİ')),
                       aciklama VARCHAR(255),
                       link VARCHAR(255),
                       ek VARCHAR(255),
                        yuklenmeTarihi DATE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       user_id BIGINT,
                       FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE
);


CREATE TABLE EGITIM (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        egitimTuru VARCHAR(255) NOT NULL CHECK (egitimTuru IN ('ILKOKUL', 'ORTAOKUL', 'LISE', 'LISANS', 'YUKSEK_LISANS', 'DOKTORA')),
                        okulAdi VARCHAR(255) NOT NULL,
                        bolum VARCHAR(255) NOT NULL,
                        baslangicTarihi DATE NOT NULL,
                        mezuniyetTarihi DATE NOT NULL,
                        aciklama TEXT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        user_id BIGINT,
                        FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE
);

CREATE TABLE DOSYA (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       dosyaTuru VARCHAR(255) NOT NULL CHECK (dosyaTuru IN ('CV')),
                       dosyaAdi VARCHAR(255) NOT NULL,
                       bolum VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       user_id BIGINT,
                       FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE
);

CREATE TABLE DENEYIM (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         kurumAdi VARCHAR(255) NOT NULL,
                         pozisyon VARCHAR(255) NOT NULL,
                         calismaSekli VARCHAR(255) NOT NULL CHECK (calismaSekli IN ('OFISTE', 'UZAKTAN', 'HIBRIT')),
                         baslamaTarihi DATE NOT NULL,
                         bitisTarihi DATE NOT NULL,
                         istenAyrilmaNedeni TEXT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         user_id BIGINT,
                         FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE
);

CREATE TABLE AUTHORITY (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           authority VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE USER_KATKI (
                            user_id BIGINT,
                            katki_id BIGINT,
                            PRIMARY KEY (user_id, katki_id),
                            FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                            FOREIGN KEY (katki_id) REFERENCES KATKI(id) ON DELETE CASCADE
);

CREATE TABLE USER_EGITIM (
                            user_id BIGINT,
                            egitim_id BIGINT,
                            PRIMARY KEY (user_id, egitim_id),
                            FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                            FOREIGN KEY (egitim_id) REFERENCES EGITIM(id) ON DELETE CASCADE
);

CREATE TABLE USER_DOSYA (
                            user_id BIGINT,
                            dosya_id BIGINT,
                            PRIMARY KEY (user_id, dosya_id),
                            FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                            FOREIGN KEY (dosya_id) REFERENCES DOSYA(id) ON DELETE CASCADE
);

CREATE TABLE USER_DENEYIM (
                            user_id BIGINT,
                            deneyim_id BIGINT,
                            PRIMARY KEY (user_id, deneyim_id),
                            FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                            FOREIGN KEY (deneyim_id) REFERENCES DENEYIM(id) ON DELETE CASCADE
);
CREATE TABLE USER_AUTHORITY (
                                user_id BIGINT,
                                authority_id BIGINT,
                                PRIMARY KEY (user_id, authority_id),
                                FOREIGN KEY (user_id) REFERENCES _USER(id) ON DELETE CASCADE,
                                FOREIGN KEY (authority_id) REFERENCES AUTHORITY(id) ON DELETE CASCADE
);

CREATE TABLE KURUMSAL_PROJE(
                                kurumsal_id BIGINT,
                                proje_id BIGINT,
                                PRIMARY KEY (kurumsal_id, proje_id),
                                FOREIGN KEY (kurumsal_id) REFERENCES KURUMSAL(id) ON DELETE CASCADE,
                                FOREIGN KEY (proje_id) REFERENCES PROJE(id) ON DELETE CASCADE
);

--Creating the trigger to automatically insert into USER_KATKI
CREATE TRIGGER trg_after_katki_insert
    AFTER INSERT ON KATKI
    FOR EACH ROW CALL "yte.ypbs.ypbs_2024_ge3.trigger.KatkiInsertTrigger";

CREATE TRIGGER trg_after_egitim_insert
    AFTER INSERT ON EGITIM
    FOR EACH ROW CALL "yte.ypbs.ypbs_2024_ge3.trigger.EgitimInsertTrigger";

CREATE TRIGGER trg_after_dosya_insert
    AFTER INSERT ON DOSYA
    FOR EACH ROW CALL "yte.ypbs.ypbs_2024_ge3.trigger.DosyaInsertTrigger";

CREATE TRIGGER trg_after_deneyim_insert
    AFTER INSERT ON DENEYIM
    FOR EACH ROW CALL "yte.ypbs.ypbs_2024_ge3.trigger.DeneyimInsertTrigger";

-- Insert example users
INSERT INTO _USER (isim, soyisim, username, password, email, telefon, cinsiyet, tcKimlikNo, akademikUnvan, aracPlakasi, acilDurumKisi, acilDurumTelefon, adres, dogumTarihi, photo, kanGrubu, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, created_at, updated_at)
VALUES
    ('Ali', 'Veli', 'ali.veli', 'password123', 'ali.veli@example.com', '05321234567', 'ERKEK', 12345678901, 'Prof. Dr.', '34ABC34', 'Ayşe Veli', '05329876543', 'Istanbul, Turkey', '1985-01-15', NULL, 'A+', TRUE, TRUE, TRUE, TRUE, NOW(), NOW()),
    ('Ayşe', 'Yılmaz', 'ayse.yilmaz', 'password123', 'ayse.yilmaz@example.com', '05329876543', 'KADIN', 98765432100, 'Dr.', '06DEF56', 'Fatma Yılmaz', '05327654321', 'Ankara, Turkey', '1990-06-30', NULL, 'B-', TRUE, TRUE, TRUE, TRUE, NOW(), NOW()),
    ('Mehmet', 'Kaya', 'mehmet.kaya', 'password123', 'mehmet.kaya@example.com', '05321239876', 'ERKEK', 13579135791, 'Doç. Dr.', '35XYZ35', 'Ali Kaya', '05325439876', 'Izmir, Turkey', '1982-11-23', NULL, '0+', TRUE, TRUE, TRUE, TRUE, NOW(), NOW()),
    ('Elif', 'Demir', 'elif.demir', 'password123', 'elif.demir@example.com', '05327654321', 'KADIN', 24680246802, 'Yrd. Doç. Dr.', '41EFG41', 'Zeynep Demir', '05325436789', 'Bursa, Turkey', '1988-04-10', NULL, 'AB-', TRUE, TRUE, TRUE, TRUE, NOW(), NOW()),
    ('Ahmet', 'Çelik', 'ahmet.celik', 'password123', 'ahmet.celik@example.com', '05323216548', 'ERKEK', 11223344556, 'Dr. Öğr. Üyesi', '07GHI07', 'Mehmet Çelik', '05325432165', 'Antalya, Turkey', '1987-09-05', NULL, 'A-', TRUE, TRUE, TRUE, TRUE, NOW(), NOW());

-- Inserting example entries into the KATKI table
-- Populating the KATKI table with various types of data
INSERT INTO KATKI (etkinlikTuru, aciklama, link, ek, yuklenmeTarihi, user_id)
VALUES
    ('EGITIM', 'Introduction to Machine Learning', 'http://example.com/ml', 'Lecture notes', '2023-01-15', 1),
    ('EGITIM', 'Advanced Data Structures', 'http://example.com/ads', 'Course materials', '2023-03-10', 2),
    ('YAYINLAR_ARAŞTIRMA_SERİSİ', 'Research on Quantum Computing', 'http://example.com/qc', 'Research paper', '2023-05-20', 3),
    ('YAYINLAR_ARAŞTIRMA_SERİSİ', 'AI and Ethics', 'http://example.com/ai-ethics', 'Journal article', '2023-07-05', 4),
    ('EGITIM', 'Workshop on Deep Learning', 'http://example.com/dl', 'Workshop summary', '2023-08-10', 5),
    ('EGITIM', 'Seminar on Cybersecurity', 'http://example.com/cyber', NULL, '2023-09-15', 1),
    ('YAYINLAR_ARAŞTIRMA_SERİSİ', 'Blockchain Technology Overview', NULL, 'Conference presentation', '2023-10-01', 2),
    ('YAYINLAR_ARAŞTIRMA_SERİSİ', 'Big Data Analytics', 'http://example.com/bigdata', 'White paper', '2023-11-10', 3),
    ('EGITIM', 'Cloud Computing Basics', 'http://example.com/cloud', NULL, '2023-12-01', 4),
    ('YAYINLAR_ARAŞTIRMA_SERİSİ', 'Internet of Things (IoT) Applications', 'http://example.com/iot', 'Technical report', '2023-12-15', 5),
    ('EGITIM', 'Data Privacy in the Digital Age', 'http://example.com/privacy', 'Seminar materials', '2024-01-05', 1),
    ('EGITIM', 'Introduction to Algorithms', 'http://example.com/algorithms', 'Course syllabus', '2024-02-10', 2);

-- Populating the EGITIM table with various types of data
INSERT INTO EGITIM (egitimTuru, okulAdi, bolum, baslangicTarihi, mezuniyetTarihi, aciklama, user_id)
VALUES
    ('ILKOKUL', 'Yildiz Ilkokulu', 'Genel', '1995-09-01', '2000-06-15', 'Primary education.', 1), -- Valid entry

    ('ORTAOKUL', 'Ataturk Ortaokulu', 'Genel', '2000-09-01', '2003-06-15', 'Secondary education.', 1), -- Valid entry

    ('LISE', 'Ankara Lisesi', 'Fen', '2003-09-01', '2007-06-15', 'High school education.', 2), -- Valid entry

    ('LISANS', 'Bogazici Universitesi', 'Bilgisayar Muhendisligi', '2007-09-01', '2011-06-15', 'Undergraduate degree.', 2), -- Valid entry

    ('YUKSEK_LISANS', 'Orta Dogu Teknik Universitesi', 'Bilgisayar Bilimleri', '2011-09-01', '2013-06-15', 'Master’s degree.', 3), -- Valid entry

    ('DOKTORA', 'Istanbul Teknik Universitesi', 'Yapay Zeka', '2013-09-01', '2018-06-15', 'Doctoral degree.', 3), -- Valid entry

    ('LISE', 'Kolej Lisesi', 'Sosyal Bilimler', '2004-09-01', '2008-06-15', NULL, 4), -- Entry with NULL aciklama

    ('LISANS', 'Hacettepe Universitesi', 'Elektrik Elektronik Muhendisligi', '2008-09-01', '2012-06-15', 'Bachelors degree.', 4), -- Valid entry

    ('YUKSEK_LISANS', 'Ege Universitesi', 'Endustri Muhendisligi', '2012-09-01', '2014-06-15', 'Master’s degree.', 5), -- Valid entry

    ('DOKTORA', 'Karadeniz Teknik Universitesi', 'Denizcilik', '2014-09-01', '2019-06-15', 'Doctoral degree.', 5), -- Valid entry

    ('LISANS', 'Uludag Universitesi', 'Makine Muhendisligi', '2005-09-01', '2009-06-15', 'Undergraduate degree.', 5), --

    ('YUKSEK_LISANS', 'Erciyes Universitesi', 'Insaat Muhendisligi', '2009-09-01', '2011-06-15', 'Master’s degree.', 1); -- Entry with all fields filled

-- Populating the DOSYA table with various types of data
INSERT INTO DOSYA (dosyaTuru, dosyaAdi, bolum, user_id)
VALUES
    ('CV', 'Ali_Veli_CV.pdf', 'Bilgisayar Muhendisligi', 1), -- Valid entry

    ('CV', 'Ayse_Yilmaz_CV.pdf', 'Elektrik Elektronik Muhendisligi', 2), -- Valid entry

    ('CV', 'Mehmet_Kaya_CV.pdf', 'Makine Muhendisligi', 3), -- Valid entry

    ('CV', 'Elif_Demir_CV.pdf', 'Yapay Zeka', 4), -- Valid entry

    ('CV', 'Ahmet_Celik_CV.pdf', 'Endustri Muhendisligi', 5), -- Valid entry

    ('CV', 'Fatma_Sahin_CV.pdf', 'Genel', 1), -- Another valid entry for user 1

    ('CV', 'Osman_Yildirim_CV.pdf', 'Sosyal Bilimler', 2), -- Another valid entry for user 2

    ('CV', 'Zeynep_Tekin_CV.pdf', 'Genel', 3), -- Another valid entry for user 3

    ('CV', 'Kemal_Kar_CV.pdf', 'Fen', 4), -- Entry with NULL user_id (should fail if user_id is NOT NULL)

    ('CV', 'Gul_Dogan_CV.pdf', 'Saglik Bilimleri', 5); -- Another valid entry for user 5

-- Populating the DENEYIM table with various types of data
INSERT INTO DENEYIM (kurumAdi, pozisyon, calismaSekli, baslamaTarihi, bitisTarihi, istenAyrilmaNedeni, user_id)
VALUES
    ('ABC Ltd.', 'Software Developer', 'OFISTE', '2020-01-01', '2022-01-01', 'Career advancement', 1), -- Valid entry
    ('XYZ Corp.', 'Project Manager', 'UZAKTAN', '2019-03-01', '2021-05-01', 'Personal reasons', 2), -- Valid entry
    ('Tech Solutions', 'Data Analyst', 'HIBRIT', '2021-06-01', '2023-01-01', 'End of contract', 3), -- Valid entry
    ('Innovative Designs', 'UI/UX Designer', 'OFISTE', '2018-07-01', '2020-12-01', 'Relocation', 4), -- Valid entry
    ('Global Tech', 'System Administrator', 'UZAKTAN', '2017-05-01', '2019-09-01', 'Better opportunity', 5), -- Valid entry
    ('Future Vision', 'DevOps Engineer', 'HIBRIT', '2020-02-01', '2023-02-01', 'Career change', 1), -- Another valid entry for user 1
    ('NextGen Innovators', 'Cybersecurity Specialist', 'OFISTE', '2016-08-01', '2018-11-01', 'Contract ended', 2), -- Another valid entry for user 2
    ('Alpha Tech', 'Machine Learning Engineer', 'UZAKTAN', '2019-10-01', '2022-03-01', 'Better salary', 3), -- Another valid entry for user 3
    ('Beta Solutions', 'Network Engineer', 'OFISTE', '2015-09-01', '2017-06-01', 'Retirement', 4), -- Another valid entry for user 4
    ('Gamma Innovations', 'Database Administrator', 'HIBRIT', '2018-01-01', '2020-07-01', 'Personal reasons', 5); -- Another valid entry for user 5

-- Populating the AUTHORITY table with example data
INSERT INTO AUTHORITY (authority)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN'),
    ('ROLE_MODERATOR');

-- Populating the USER_AUTHORITY table with example data
INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES
    (1, 1), -- Assigning ROLE_USER to user with id 1
    (1, 2), -- Assigning ROLE_ADMIN to user with id 1
    (2, 1), -- Assigning ROLE_USER to user with id 2
    (3, 3), -- Assigning ROLE_MODERATOR to user with id 3
    (4, 1), -- Assigning ROLE_USER to user with id 4
    (5, 2); -- Assigning ROLE_ADMIN to user with id 5


INSERT INTO ORGANIZATION (top_org_id, name) VALUES
                                                (NULL, 'TUBITAK'),  -- Root organization
                                                (1, 'BİLGEM'),       -- Sub-organization of GlobalCorp
                                                (1, 'SAGE'),     -- Sub-organization of GlobalCorp
                                                (2, 'ILTAREN'),  -- Sub-organization of TechCorp
                                                (2, 'YTE');  -- Sub-organization of TechCorp

-- Populate KURUMSAL table
INSERT INTO KURUMSAL (user_id, org_id, iseGirisTarihi, sicilNo, kadro, unvan, gorev, persolenTuru, calismaTuru, calismaDurumu, servisKullanimi, dahiliNumara, odaNumara) VALUES
             (1, 1, '2021-05-01', 12345, 'Engineering', 'Senior Developer', 'Lead Developer', 'YONETICI', 'TAM_ZAMANLI', 'AKTIF', TRUE, '1001', 101),
             (2, 2, '2022-03-15', 67890, 'Medical', 'Nurse', 'Staff Nurse', 'CALISAN', 'YARI_ZAMANLI', 'AKTIF', TRUE, '2002', 202),
             (3, 3, '2020-07-20', 54321, 'Education', 'Professor', 'Lecturer', 'YONETICI', 'TAM_ZAMANLI', 'PASIF', FALSE, '3003', 303),
             (4, 4, '2019-11-25', 98765, 'Finance', 'Analyst', 'Financial Analyst', 'CALISAN', 'SERBEST', 'IZINLI', TRUE, '4004', 404),
             (5, 5, '2023-02-10', 13579, 'Energy', 'Technician', 'Junior Technician', 'STAJYER', 'TAM_ZAMANLI', 'AKTIF', FALSE, '5005', 505);

-- Populate PROJE table
INSERT INTO PROJE (projeAdi, takim, baslangicTarihi, bitisTarihi) VALUES
                                                                      ('AI Research', 'AI Team', '2023-01-01', '2023-12-31'),
                                                                      ('Web Development', 'Web Team', '2023-02-01', '2023-11-30'),
                                                                      ('Mobile App Development', 'Mobile Team', '2023-03-01', '2023-10-31'),
                                                                      ('Data Analysis', 'Data Team', '2023-04-01', '2023-09-30'),
                                                                      ('Cybersecurity', 'Security Team', '2023-05-01', '2023-08-31');

-- Populate GOREV table
INSERT INTO GOREV (user_id, proje_id, gorev) VALUES
                                                 (1, 1, 'Project Manager'),
                                                 (2, 2, 'Lead Developer'),
                                                 (3, 3, 'Research Lead'),
                                                 (4, 4, 'Data Analyst'),
                                                 (5, 5, 'Technical Support'),
                                                 (1, 2, 'Consultant'),
                                                 (3, 5, 'Advisor'),
                                                 (2, 4, 'Assistant'),
                                                 (4, 1, 'Data Scientist'),
                                                 (5, 3, 'Support Staff');
-- Populate ORGANIZATION table with hierarchical structure

-- Populate KURUMSAL_PROJE table with example entries
INSERT INTO KURUMSAL_PROJE (kurumsal_id, proje_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 3),
                                                       (3, 4),
                                                       (4, 5),
                                                       (2, 1),
                                                       (3, 2),
                                                       (4, 3),
                                                       (5, 4),
                                                       (5, 5);

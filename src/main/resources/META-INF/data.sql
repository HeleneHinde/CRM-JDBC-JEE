SET search_path TO crm_jee;

INSERT INTO users (username, password, mail, grants) VALUES ('toto', '1234', 'toto@titi.com', 'ADMIN');INSERT INTO crm_jee.customers (lastname, firstname, company, mail, phone, mobile, notes, active) VALUES
('Martin', 'Jean', 'TechCorp', 'jean.martin@techcorp.com', '0123456789', '0612345678', 'Client important VIP', true),
('Dupont', 'Marie', 'WebAgency', 'marie.dupont@webagency.com', '0123456790', '0612345679', 'Nouveau client prometteur', true),
('Bernard', 'Pierre', NULL, 'pierre.bernard@email.com', '0123456791', '0612345680', 'Client particulier fidèle', true),
('Leroy', 'Sophie', 'StartupTech', 'sophie.leroy@startup.com', '0123456792', '0612345681', 'Startup innovante', true),
('Garcia', 'Antoine', 'BigCorp', 'antoine.garcia@bigcorp.com', '0123456793', '0612345682', 'Gros client entreprise', true),
('Petit', 'Claire', 'DesignStudio', 'claire.petit@design.com', '0123456794', '0612345683', 'Studio créatif', true),
('Moreau', 'Lucas', 'DevCompany', 'lucas.moreau@dev.com', '0123456795', '0612345684', 'Société de développement', true),
('Simon', 'Emma', 'EcommercePlus', 'emma.simon@ecommerce.com', '0123456796', '0612345685', 'Plateforme e-commerce', true);

-- Insérer des users de test
INSERT INTO crm_jee.users (username, password, mail, grants) VALUES
('admin', 'admin123', 'admin@crm.com', 'ADMIN'),
('manager', 'manager123', 'manager@crm.com', 'MANAGER'),
('user', 'user123', 'user@crm.com', 'USER'),
('support', 'support123', 'support@crm.com', 'SUPPORT'),
('commercial', 'commercial123', 'commercial@crm.com', 'USER');

-- Insérer des orders de test (en utilisant les IDs des customers créés)
INSERT INTO crm_jee.orders (customer_id, label, adr_et, number_of_days, tva, status, type, notes) VALUES
(1, 'Développement site web corporate', 450.00, 10, 20.00, 'PENDING', 'DEVELOPMENT', 'Site vitrine moderne avec CMS'),
(2, 'Consulting SEO avancé', 300.00, 5, 20.00, 'IN_PROGRESS', 'CONSULTING', 'Audit et optimisation référencement'),
(3, 'Support technique annuel', 150.00, 3, 20.00, 'COMPLETED', 'SUPPORT', 'Maintenance serveur et applications'),
(4, 'Application mobile native', 600.00, 15, 20.00, 'PENDING', 'DEVELOPMENT', 'App iOS/Android avec API REST'),
(5, 'Formation équipe React/Node', 400.00, 2, 20.00, 'COMPLETED', 'CONSULTING', 'Formation développeurs junior'),
(6, 'Refonte UX/UI complète', 350.00, 8, 20.00, 'IN_PROGRESS', 'DEVELOPMENT', 'Nouveau design system'),
(7, 'Audit sécurité informatique', 500.00, 4, 20.00, 'PENDING', 'CONSULTING', 'Analyse vulnérabilités et pentest'),
(8, 'E-commerce Shopify Plus', 550.00, 12, 20.00, 'IN_PROGRESS', 'DEVELOPMENT', 'Boutique en ligne haute performance');
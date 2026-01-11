public class TestsAssertions {

        @Test
        void testEntierM2013negatif() {
            int nombre = DataProvider.getMoinsDeuxMilleTreize();
            assertThat(nombre).isNegative();
        }

        @Test
        void testEntierM2013proche() {
            int nombre = DataProvider.getMoinsDeuxMilleTreize();
            assertThat(nombre).isCloseTo(-2000, within(20));
        }

        @Test
        void testEntierM2013multiple11() {
            int nombre = DataProvider.getMoinsDeuxMilleTreize();
            assertThat(nombre % 11).isEqualTo(0);
        }

        @Test
        void testEntierM2013dansListe() {
            int nombre = DataProvider.getMoinsDeuxMilleTreize();
            assertThat(nombre).isIn(137, 2, 1000, 13, 2014, -2013, -2);
        }

        @Test
        void testReelM271valide() {
            float nombre = DataProvider.getMoinsDeuxPointSeptUn();
            assertThat(nombre).isNotNaN().isFinite();
        }

        @Test
        void testReelM271entreM2etM3() {
            float nombre = DataProvider.getMoinsDeuxPointSeptUn();
            assertThat(nombre).isBetween(-3f, -2f);
        }

        @Test
        void testReelM271nonEntier() {
            float nombre = DataProvider.getMoinsDeuxPointSeptUn();
            assertThat(nombre).isNotEqualTo(Math.floor(nombre));
        }

        @Test
        void testInfini() {
            float nombre = DataProvider.getMInfini();
            assertThat(nombre).isInfinite();
        }

        @Test
        void testGouvernailsLongueur11() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).hasSize(11);
        }

        @Test
        void testGouvernailsFinitParS() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).endsWith("s");
        }

        @Test
        void testGouvernailsContientGou() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).containsIgnoringCase("gou");
        }

        @Test
        void testGouvernailsContientAilMaisPasVers() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).contains("ail").doesNotContain("vers");
        }
    
        @Test
        void testGouvernailsContientLettresARES() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).contains("a", "r", "e", "s");
        }
    
        @Test
        void testGouvernailsContientMajusculesEtMinuscules() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).matches(".*[a-z].*").matches(".*[A-Z].*");
        }
    
        @Test
        void testGouvernailsContientAucunChiffre() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).doesNotContainPattern("\\d");
        }
    
        @Test
        void testGouvernailsCommenceMajuscule() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine).matches("^[A-Z].*");
        }
    
        @Test
        void testGouvernailsContientUniquementDesCaracteresUniques() {
            String chaine = DataProvider.getGouvernails();
            assertThat(chaine.chars().distinct().count()).isEqualTo((long) chaine.length());
        }
    
        @Test
        void testVehiculeV1classe() {
            Vehicule v1 = DataProvider.getVehicule1();
            assertThat(v1).isInstanceOf(Vehicule.class);
        }
    
        @Test
        void testVehiculeV1classeStricte() {
            Vehicule v1 = DataProvider.getVehicule1();
            assertThat(v1.getClass()).isEqualTo(Vehicule.class);
        }
    
        @Test
        void testVehiculeV2classeVeloStricte() {
            Vehicule v2 = DataProvider.getVehicule2();
            assertThat(v2.getClass()).isEqualTo(Velo.class);
        }
    
        @Test
        void testVehiculeV1pasNull() {
            Vehicule v1 = DataProvider.getVehicule1();
            assertThat(v1).isNotNull();
        }
    
        @Test
        void testVehiculeV2diffV3() {
            Vehicule v2 = DataProvider.getVehicule2();
            Vehicule v3 = DataProvider.getVehicule3();
            assertThat(v2).isNotSameAs(v3);
        }
    
        @Test
        void testVehiculeV2commeV3() {
            Vehicule v2 = DataProvider.getVehicule2();
            Vehicule v3 = DataProvider.getVehicule3();
            assertThat(v2).usingRecursiveComparison().isEqualTo(v3);
        }
    
        @Test
        void testVehiculeV3commeV4saufPrix() {
            Vehicule v3 = DataProvider.getVehicule3();
            Vehicule v4 = DataProvider.getVehicule4();
            assertThat(v3).usingRecursiveComparison().ignoringFields("prix").isEqualTo(v4);
        }
    
        @Test
        void testVehiculeV5commeV1saufNulls() {
            Vehicule v5 = DataProvider.getVehicule5();
            Vehicule v1 = DataProvider.getVehicule1();
            assertThat(v5).usingRecursiveComparison().ignoringExpectedNullFields().isEqualTo(v1);
        }
    
        @Test
        void testListeNonVide() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).isNotEmpty();
        }

        @Test
        void testListeContientTout() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).contains("tout");
        }

        @Test
        void testListe4eElement() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).element(3).isEqualTo("tout");
        }

        @Test
        void testListeContientExactementUnNull() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).filteredOn(e -> e == null).hasSize(1);
        }

        @Test
        void testListeNeContientPasChaineVide() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).doesNotContain("");
        }

        @Test
        void testListeNeContientPasQueNull() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).filteredOn(e -> e != null).isNotEmpty();
        }

        @Test
        void testListeChainesToutesEntre1et6Chars() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).filteredOn(e -> e instanceof String)
                            .allMatch(e -> ((String) e).length() >= 1 && ((String) e).length() <= 6);
        }

        @Test
        void testListeContientUniquementDesStrings() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).allSatisfy(e -> assertThat(e).isInstanceOfAny(String.class, null));
        }

        @Test
        void testListeNeContientPasDeChainesEnDouble() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).doesNotHaveDuplicates();
        }

        @Test
        void testListeElementsParmi() {
            List<Object> liste = DataProvider.getListe();
            assertThat(liste).containsOnly("ici", "le", "groupe", "a", 17, "me", "dit", 23, "salut", "tout", "temps", null);
        }

        @Test
        void testFichierExtensionTXT() {
            String nom = DataProvider.getDataFileName();
            assertThat(nom).endsWith(".txt");
        }

        @Test
        void testFichierEstUnFichierLisible() {
            File file = new File(DataProvider.getDataFileName());
            assertThat(file).exists().canRead().isFile();
        }

        @Test
        void testFichierPasVide() {
            File file = new File(DataProvider.getDataFileName());
            assertThat(file.length()).isGreaterThan(0);
        }

        private static final Charset UTF_8 = StandardCharsets.UTF_8;

        @Test
        void testFichierContientEntre3et6lignes() {
            File file = new File(DataProvider.getDataFileName());
            List<String> lignes = Files.linesOf(file, UTF_8);
            assertThat(lignes).hasSizeBetween(3, 6);
        }

        @Test
        void testFichierContientLignesCommençantParLigne() {
            File file = new File(DataProvider.getDataFileName());
            List<String> lignes = Files.linesOf(file, UTF_8);
            assertThat(lignes).allMatch(ligne -> ligne.startsWith("ligne "));
        }

        @Test
        void testFichierContientLignesLigneNombre() {
            File file = new File(DataProvider.getDataFileName());
            List<String> lignes = Files.linesOf(file, UTF_8);
            assertThat(lignes).allMatch(ligne -> ligne.matches("ligne \\d+"));
}

    }
    

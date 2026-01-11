"""Fonctions preliminaires"""

def convert_ASCII(texte):
    return [ord(char) for char in texte]

def convert_CHAR(ascii):
    return ''.join(chr(code) for code in ascii)

"""Chiffrement de Cesar"""

# 1 et 2. Codage du texte "info" avec un decalage de 5
def chiffre_Cesar(texte, key):
    return [(char + key - 97) % 26 + 97 for char in texte]

# 3. Fonction de dechiffrement
def dechiffre_Cesar(texte, key):
    return [(char - key - 97) % 26 + 97 for char in texte]


# 4. Fonction d'analyse de frequence
def frequence(texte):
    freq = {}
    for char in texte:
        if char in freq:
            freq[char] += 1
        else:
            freq[char] = 1
    return [[ord(char), count] for char, count in freq.items()]

"""# 5. Test de frequence(texte)
texte = "\"Would it be of any use, now,\" thought Alice, \"to speak to this mouse? The rabbit is something quite out-of-the-way, no doubt, and so have I been, ever since I came down here, but that is no reason why the mouse should not be able to talk. I think I may as well try.\" So she began: \"oh Mouse, do you know how to get out of this pool? I am very tired of swimming about here, oh Mouse!\" The mouse looked at her rather inquisitively, and seemed to her to wink with one of its little eyes, but it said nothing. \"Perhaps it doesn't understand English,\" thought Alice; \"I daresay it's a French mouse, come over with William the Conqueror!\" (for, with all her knowledge of history, Alice had no very clear notion how long ago anything had happened,) so she began again: \"oÃ¹ est ma chatte?\" which was the first sentence in her French lesson-book. The mouse gave a sudden jump in the pool, and seemed to quiver with fright: \"oh, I beg your pardon!\" cried Alice hastily, afraid that she had hurt the poor animal's feelings, \"I quite forgot you didn't like cats!\" \"Not like cats!\" cried the mouse, in a shrill, passionate voice, \"would you like cats if you were me?\" \"Well, perhaps not,\" said Alice in a soothing tone, \"don't be angry about it. And yet I wish I could show you our cat Dinah: I think you'd take a fancy to cats if you could only see her. She is such a dear quiet thing,\" said Alice, half to herself, as she swam lazily about in the pool, \"she sits purring so nicely by the fire, licking her paws and washing her face: and she is such a nice soft thing to nurse, and she's such a capital one for catching mice - oh! I beg your pardon!\" cried poor Alice again, for this time the mouse was bristling all over, and she felt certain it must be really offended, \"have I offended you?\" \"Offended indeed!\" cried the mouse, who seemed to be positively trembling with rage, \"our family always hated cats! Nasty, low, vulgar things! Don't talk to me about them any more!\" \"I won't indeed!\" said Alice, in a great hurry to change the conversation, \"are you-are you-fond of-dogs?\" The mouse did not answer, so Alice went on eagerly: \"there is such a nice little dog near our house I should like to show you! A little bright-eyed terrier, you know, with oh! such long curly brown hair! And it'll fetch things when you throw them, and it'll sit up and beg for its dinner, and all sorts of things-I ca'n't remember half of them-and it belongs to a farmer, and he says it kills all the rats and-oh dear!\" cried Alice sadly, \"I'm afraid I've offended it again!\" for the mouse was swimming away from her as hard as it could go, and making quite a commotion in the pool as it went. So she called softly after it: \"mouse dear! Do come back again, and we won't talk about cats and dogs any more, if you don't like them!\" When the mouse heard this, it turned and swam slowly back to her: its face was quite pale (with passion, Alice thought), and it said in a trembling low voice \"let's get to the shore, and then I'll tell you my history, and you'll understand why it is I hate cats and dogs.\" It was high time to go, for the pool was getting quite full of birds and animals that had fallen into it. There was a Duck and a Dodo, a Lory and an Eaglet, and several other curious creatures. Alice led the way, and the whole party swam to the shore."
resultat = frequence(texte)
print(resultat)"""


# 6. Fonction de cryptanalyse
def cryptanalyse(cipher):
    valeurs_ascii = [ord(char) for char in cipher]
    freq = frequence(valeurs_ascii)
    freq.sort(key=lambda x: x[1], reverse=True)
    plus_frequent = freq[0][0]
    key = (plus_frequent - 101) % 256
    return key

"""# Test
cipher = "[ol'yhiip{4ovsl'~lu{'z{yhpno{'vu'sprl'h'{|uuls'mvy'zvtl'~h\x803'huk'{olu'kpwwlk'z|kklus\x80'kv~u3'zv'z|kklus\x803'{oh{'Hspjl'ohk'uv{'h'tvtlu{'{v'{opur'hiv|{'z{vwwpun'olyzlsm3'ilmvyl'zol'mv|uk'olyzlsm'mhsspun'kv~u'~oh{'zlltlk'h'kllw'~lss5'Lp{oly'{ol'~lss'~hz'}ly\x80'kllw3'vy'zol'mlss'}ly\x80'zsv~s\x803'mvy'zol'ohk'wslu{\x80'vm'{ptl'hz'zol'~lu{'kv~u'{v'svvr'hiv|{'oly3'huk'{v'~vukly'~oh{'~v|sk'ohwwlu'ul\x7f{5'Mpyz{3'zol'{yplk'{v'svvr'kv~u'huk'thrl'v|{'~oh{'zol'~hz'jvtpun'{v3'i|{'p{'~hz'{vv'khyr'{v'zll'hu\x80{opunA'{olu3'zol'svvrlk'h{'{ol'zpklz'vm'{ol'~lss3'huk'uv{pjlk'{oh{'{ol\x80'~lyl'mpsslk'~p{o'j|wivhykz'huk'ivvr4zols}lzB'olyl'huk'{olyl'~lyl'thwz'huk'wpj{|ylz'o|un'vu'wlnz5'Zol'{vvr'h'qhy'kv~u'vmm'vul'vm'{ol'zols}lz'hz'zol'whzzlkA'p{'~hz'shilsslk')Vyhunl'Thythshkl3)'i|{'{v'oly'nylh{'kpzhwwvpu{tlu{'p{'~hz'ltw{\x80A'zol'kpk'uv{'sprl'{v'kyvw'{ol'qhy3'mvy'mlhy'vm'rpsspun'zvtlivk\x80'|uklyulh{o3'zv'thuhnlk'{v'w|{'p{'pu{v'vul'vm'{ol'j|wivhykz'hz'zol'mlss'whz{'p{5)^lss()'{ov|no{'Hspjl'{v'olyzlsm3')hm{ly'z|jo'h'mhss'hz'{opz3'P'zohss'{opur'uv{opun'vm'{|tispun'kv~u'z{hpyz('Ov~'iyh}l'{ol\x80.ss'hss'{opur'tl'h{'ovtl('^o\x803'P'~v|sku.{'zh\x80'hu\x80{opun'hiv|{'p{3'l}lu'pm'P'mlss'vmm'{ol'{vw'vm'{ol'ov|zl()'/~opjo'~hz'tvz{'sprls\x80'{y|l505'Kv~u3'kv~u3'kv~u5'^v|sk'{ol'mhss'ul}ly'jvtl'{v'hu'lukF')P'~vukly'ov~'thu\x80'tpslz'P.}l'mhsslu'i\x80'{opz'{ptlF)'zhpk'zol'hsv|k3')P't|z{'il'nl{{pun'zvtl~olyl'ulhy'{ol'jlu{yl'vm'{ol'lhy{o5'Sl{'tl'zllA'{oh{'~v|sk'il'mv|y'{ov|zhuk'tpslz'kv~u3'P'{opur\xe9\x87\x9b)'/mvy'\x80v|'zll'Hspjl'ohk'slhyu{'zl}lyhs'{opunz'vm'{opz'zvy{'pu'oly'slzzvuz'pu'{ol'zjovvsyvvt3'huk'{ov|no'{opz'~hz'uv{'h'}ly\x80'nvvk'vwwvy{|up{\x80'vm'zov~pun'vmm'oly'ruv~slknl3'hz'{olyl'~hz'uv'vul'{v'olhy'oly3'z{pss'p{'~hz'nvvk'wyhj{pjl'{v'zh\x80'p{'v}ly30')\x80lz3'{oh{.z'{ol'ypno{'kpz{hujl3'i|{'{olu'P'~vukly'~oh{'Svunp{|kl'vy'Sh{p{|kl4spul'zohss'P'il'puF)'/Hspjl'ohk'uv'pklh'~oh{'Svunp{|kl'~hz3'vy'Sh{p{|kl'lp{oly3'i|{'zol'{ov|no{'{ol\x80'~lyl'upjl'nyhuk'~vykz'{v'zh\x8050"
key = cryptanalyse(cipher)
print("Je pense que la cle est:", key)"""

"""Chiffrement par substitution"""

# 1. Procedure creation_alphabet(clef)
def creation_alphabet(clef):
    clef = ''.join(sorted(set(clef), key=clef.index)).upper()
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    for lettre in alphabet:
        if lettre not in clef:
            clef += lettre
    return clef

# 2. Procedure chiffrement(texte, clef)
def chiffrement(texte, clef):
    alphabet = creation_alphabet(clef)
    texte = texte.upper()
    substitution = {chr(65 + i): alphabet[i] for i in range(26)}
    texte_chiffre = ''.join(substitution.get(char, char) for char in texte)
    return texte_chiffre

# 3. Decrypter le message
def dechiffrement(texte_chiffre, clef):
    alphabet = creation_alphabet(clef)
    substitution_inverse = {alphabet[i]: chr(65 + i) for i in range(26)}
    texte_dechiffre = ''.join(substitution_inverse.get(char, char) for char in texte_chiffre)
    return texte_dechiffre

"""Chiffre de Vigenere"""

# 1. Fonction chiffreVigenere(texte, key)
def chiffreVigenere(texte, key):
    return [(texte[i] + key[i % len(key)]) % 26 for i in range(len(texte))]

# 2. Fonction pgcd
def pgcd(a, b):
    while b:
        a, b = b, a % b
    return a

# 3. Fonction pgcdDistancesEntreRepetitions
def pgcdDistancesEntreRepetitions(t, i):
    sequence = t[i:i+3]
    distances = []
    for j in range(len(t) - 2):
        if t[j:j+3] == sequence:
            distances.append(j - i)
    if not distances:
        return 0
    pgcd_resultat = distances[0]
    for distance in distances[1:]:
        pgcd_resultat = pgcd(pgcd_resultat, distance)
    
    return pgcd_resultat

# 4. Fonction longueurCle
def longueurCle(t):
    k_valeurs = []
    for i in range(len(t) - 2):
        pgcd_resultat = pgcdDistancesEntreRepetitions(t, i)
        if pgcd_resultat > 0:
            k_valeurs.append(pgcd_resultat)
    if not k_valeurs:
        return 0
    longueur = k_valeurs[0]
    for k in k_valeurs[1:]:
        longueur = pgcd(longueur, k)
    return longueur

# 5. Fonction extraction
def extraction(t, i):
    return [t[j] for j in range(i, len(t), i)]

# 6. Fonction trouveCle
def frequenceLettre(text):
    frequence = [0] * 26
    for char in text:
        if 0 <= char < 26:
            frequence[char] += 1
    plus_frequente_i = frequence.index(max(frequence))
    return plus_frequente_i

def trouveCle(t, k):
    clef = []
    for i in range(k):
        texte_extrait = extraction(t, i)
        plus_frequente_i = frequenceLettre(texte_extrait)
        decalage = (plus_frequente_i - 4) % 26
        clef.append(decalage)
    return clef
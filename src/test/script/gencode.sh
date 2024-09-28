#!/bin/sh

# Auteur : gl37

#shell script inspired by the given tests
cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:"$PATH"

rm -f ./src/test/deca/codegen/valid/notProvided/whileTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/ifTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/declVarTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/assignTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/moduloTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/plusTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/doubleAssignTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/unaryMinusTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/notEqualsTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/andTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/greaterTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/lowerOrEqualTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/multiplyTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/notTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/opBoolTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/divideTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/floatTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/convFloatTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/emptyMainTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/advancedDivideTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/advancedTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/ifsTest.ass 2>/dev/null
rm -f ./src/test/deca/codegen/valid/notProvided/minusTest.ass 2>/dev/null


decac ./src/test/deca/codegen/valid/notProvided/whileTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/ifTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/declVarTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/assignTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/moduloTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/plusTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/doubleAssignTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/unaryMinusTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/notEqualsTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/andTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/greaterTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/lowerOrEqualTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/multiplyTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/notTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/opBoolTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/divideTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/floatTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/convFloatTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/emptyMainTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/advancedDivideTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/advancedTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/ifsTest.deca || exit 1
decac ./src/test/deca/codegen/valid/notProvided/minusTest.deca || exit 1






if [ ! -f ./src/test/deca/codegen/valid/notProvided/whileTest.ass  ]; then
    echo "Fichier whileTest.ass non généré."
    exit 1
fi

if [ ! -f ./src/test/deca/codegen/valid/notProvided/ifTest.ass  ]; then
    echo "Fichier ifTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/declVarTest.ass  ]; then
    echo "Fichier declVarTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/assignTest.ass  ]; then
    echo "Fichier assignTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/moduloTest.ass  ]; then
    echo "Fichier moduloTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/plusTest.ass  ]; then
    echo "Fichier plusTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/doubleAssignTest.ass  ]; then
    echo "Fichier doubleAssignTest.ass non généré."
    exit 1
fi


if [ ! -f ./src/test/deca/codegen/valid/notProvided/unaryMinusTest.ass  ]; then
    echo "Fichier unaryMinusTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/notEqualsTest.ass  ]; then
    echo "Fichier notEqualsTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/andTest.ass  ]; then
    echo "Fichier andTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/greaterTest.ass  ]; then
    echo "Fichier greaterTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/lowerOrEqualTest.ass  ]; then
    echo "Fichier lowerOrEqualTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/multiplyTest.ass  ]; then
    echo "Fichier multiplyTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/notTest.ass  ]; then
    echo "Fichier notTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/opBoolTest.ass  ]; then
    echo "Fichier opBoolTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/divideTest.ass  ]; then
    echo "Fichier divideTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/floatTest.ass  ]; then
    echo "Fichier floatTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/convFloatTest.ass  ]; then
    echo "Fichier convFloatTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/emptyMainTest.ass  ]; then
    echo "Fichier emptyMainTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/advancedDivideTest.ass  ]; then
    echo "Fichier advancedDivideTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/advancedTest.ass  ]; then
    echo "Fichier advancedTest.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/ifsTest.ass  ]; then
    echo "Fichier emptyInstruction.ass non généré."
    exit 1
fi
if [ ! -f ./src/test/deca/codegen/valid/notProvided/minusTest.ass  ]; then
    echo "Fichier minusTest.ass non généré."
    exit 1
fi


#results

resultat1=$(ima ./src/test/deca/codegen/valid/notProvided/whileTest.ass) || exit 1
resultat2=$(ima ./src/test/deca/codegen/valid/notProvided/ifTest.ass) || exit 1
resultat3=$(ima ./src/test/deca/codegen/valid/notProvided/declVarTest.ass) || exit 1
resultat4=$(ima ./src/test/deca/codegen/valid/notProvided/assignTest.ass) || exit 1
resultat5=$(ima ./src/test/deca/codegen/valid/notProvided/moduloTest.ass) || exit 1
resultat6=$(ima ./src/test/deca/codegen/valid/notProvided/plusTest.ass) || exit 1
resultat7=$(ima ./src/test/deca/codegen/valid/notProvided/doubleAssignTest.ass) || exit 1
resultat8=$(ima ./src/test/deca/codegen/valid/notProvided/unaryMinusTest.ass) || exit 1
resultat9=$(ima ./src/test/deca/codegen/valid/notProvided/notEqualsTest.ass) || exit 1
resultat10=$(ima ./src/test/deca/codegen/valid/notProvided/andTest.ass) || exit 1
resultat11=$(ima ./src/test/deca/codegen/valid/notProvided/greaterTest.ass) || exit 1
resultat12=$(ima ./src/test/deca/codegen/valid/notProvided/lowerOrEqualTest.ass) || exit 1
resultat13=$(ima ./src/test/deca/codegen/valid/notProvided/multiplyTest.ass) || exit 1
resultat14=$(ima ./src/test/deca/codegen/valid/notProvided/notTest.ass) || exit 1
resultat15=$(ima ./src/test/deca/codegen/valid/notProvided/opBoolTest.ass) || exit 1
resultat16=$(ima ./src/test/deca/codegen/valid/notProvided/divideTest.ass) || exit 1
resultat17=$(ima ./src/test/deca/codegen/valid/notProvided/floatTest.ass) || exit 1
resultat18=$(ima ./src/test/deca/codegen/valid/notProvided/convFloatTest.ass) || exit 1
resultat19=$(ima ./src/test/deca/codegen/valid/notProvided/emptyMainTest.ass) || exit 1
resultat20=$(ima ./src/test/deca/codegen/valid/notProvided/advancedDivideTest.ass) || exit 1
resultat21=$(ima ./src/test/deca/codegen/valid/notProvided/advancedTest.ass) || exit 1
resultat22=$(ima ./src/test/deca/codegen/valid/notProvided/ifsTest.ass) || exit 1
resultat23=$(ima ./src/test/deca/codegen/valid/notProvided/minusTest.ass) || exit 1



#removing .ass files
rm -f ./src/test/deca/codegen/valid/notProvided/whileTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/ifTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/declVarTest.as
rm -f ./src/test/deca/codegen/valid/notProvided/assignTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/moduloTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/plusTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/doubleAssignTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/unaryMinusTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/notEqualsTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/andTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/greaterTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/lowerorEqualTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/multiplyTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/notTest.ass 
rm -f ./src/test/deca/codegen/valid/notProvided/opBoolTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/divideTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/floattest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/convFloatTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/emptyMainTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/advancedDivideTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/advancedTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/ifsTest.ass
rm -f ./src/test/deca/codegen/valid/notProvided/minusTest.ass




#expected output
attendu1=5
attendu2="i et j ne sont pas égaux"
attendu3=1
attendu4=19
attendu5=0
attendu6=471
attendu7=5
attendu8=-5
attendu9="equals"
attendu10="ok"
attendu11=0
attendu12="ok"
attendu13=36900
attendu14="ok"
attendu15="ok"
attendu16=3
attendu17=3.00000e+01
attendu18=4.71000e+02
attendu19=
attendu20=1
attendu21="Successi, j and k are equalother scenarioother scenarioother scenarioother scenario"
attendu22="ok"
attendu23=10

#we compare outputs
if [ "$resultat1" = "$attendu1" ]; then
    echo  "\033[1;37mTest 1 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 1 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat2" = "$attendu2" ]; then
    echo  "\033[1;37mTest 2 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 2 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat3" = "$attendu3" ]; then
    echo  "\033[1;37mTest 3 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 3 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat4" = "$attendu4" ]; then
    echo  "\033[1;37mTest 4 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 4 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat5" = "$attendu5" ]; then
    echo  "\033[1;37mTest 5 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 5 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat6" = "$attendu6" ]; then
    echo  "\033[1;37mTest 6 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 6 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat7" = "$attendu7" ]; then
    echo  "\033[1;37mTest 7 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 7 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat8" = "$attendu8" ]; then
    echo  "\033[1;37mTest 8 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 8 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat9" = "$attendu9" ]; then
    echo  "\033[1;37mTest 9 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 9 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat10" = "$attendu10" ]; then
    echo  "\033[1;37mTest 10 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 10 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat11" = "$attendu11" ]; then
    echo  "\033[1;37mTest 11 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 11 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat12" = "$attendu12" ]; then
    echo  "\033[1;37mTest 12 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 12 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat13" = "$attendu13" ]; then
    echo  "\033[1;37mTest 13 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 13 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat14" = "$attendu14" ]; then
    echo  "\033[1;37mTest 14 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 14 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat15" = "$attendu15" ]; then
    echo  "\033[1;37mTest 15 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 15 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat16" = "$attendu16" ]; then
    echo  "\033[1;37mTest 16 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 16 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat17" = "$attendu17" ]; then
    echo  "\033[1;37mTest 17 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 17 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat18" = "$attendu18" ]; then
    echo  "\033[1;37mTest 18 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 18 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat19" = "$attendu19" ]; then
    echo  "\033[1;37mTest 19 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 19 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat20" = "$attendu20" ]; then
    echo  "\033[1;37mTest 20 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 20 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat21" = "$attendu21" ]; then
    echo  "\033[1;37mTest 21 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 21 \033[1;31;1mFailed\033[0m"
    exit 1
fi

if [ "$resultat22" = "$attendu22" ]; then
    echo  "\033[1;37mTest 22 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 22 \033[1;31;1mFailed\033[0m"
    exit 1
fi
if [ "$resultat23" = "$attendu23" ]; then
    echo  "\033[1;37mTest 23 \033[1;32mPASSED\033[0m"
else
    echo "\033[1;37mTest 23 \033[1;31;1mFailed\033[0m"
    exit 1
fi




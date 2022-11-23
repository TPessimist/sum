import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dataProcessing.SyRegularRecipeUtils.killRegularRecipe;

public class RegularTest {
    public static void main(String args[]) throws Exception {
        String regularRecipe = "ReservoirName=L740\n" +
                "ReservoirDescription=P:??\u0003\n" +
                "ReservoirAuthor=EE\n" +
                "ReservoirDate=12/23/2017 10:13\n" +
                "ReservoirMetal=Copper\n" +
                "ReservoirChemistryVendor=<None>\n" +
                "ReservoirIdleFlow=true\n" +
                "ReservoirTempFaultHigh=28\n" +
                "ReservoirTempWarningHigh=27\n" +
                "ReservoirTempSetPoint=25\n" +
                "ReservoirTempWarningLow=23\n" +
                "ReservoirTempFaultLow=22\n" +
                "ReservoirFlowWarningLo=5\n" +
                "ReservoirFlowFaultLo=3\n" +
                "ReservoirLevelHigh=125\n" +
                "ReservoirLevelSetPoint=115\n" +
                "ReservoirLevelLow=100\n" +
                "ReservoirEnableDIReplen=false\n" +
                "ReservoirEnableChemReplen=false\n" +
                "OxidationEnabled=false\n" +
                "OxidationHighFault=200\n" +
                "OxidationSetpoint=100\n" +
                "OxidationLowFault=0\n" +
                "ReservoirANLevelHigh=16\n" +
                "ReservoirANLevelSetPoint=8\n" +
                "ReservoirANLevelLow=3\n" +
                "ReservoirANEnableDIReplen=false\n" +
                "ReservoirANFlowFaultLo=0.3\n" +
                "ReservoirANFlowWarningLo=0.5\n" +
                "ReservoirANFlowSetPoint=0.7\n" +
                "ReservoirCAFlowSetPoint=10\n" +
                "ReservoirReplenAutoDoseEnabled=false\n" +
                "ReservoirReplenAutoDoseFrequency=0\n" +
                "ReservoirReplenBleedTimeRate=0\n" +
                "ReservoirReplenBleedCurrentRate=0\n" +
                "ReservoirReplenCrossDoseTimeRate=0\n" +
                "ReservoirReplenCrossDoseCurrentRate=0\n" +
                "ReservoirReplenIdleStartTime=0\n" +
                "ReservoirANLevelLow=4\n" +
                "DIReplenTimeRate=0\n" +
                "DIReplenCurrentRate=0\n" +
                "DIReplenNoCircFactor=1\n" +
                "AN_DIReplenTimeRate=0\n" +
                "AN_DIReplenCurrentRate=0\n" +
                "AN_DIReplenNoCircFactor=1\n" +
                "BurninIdleTimeLimitEnable=false\n" +
                "BurninIdleTimeLimitCurrent=0\n" +
                "ReservoirReplen1Enable=false\n" +
                "ReservoirReplen1Chem=test1\n" +
                "ReservoirReplen1TimeBased=false\n" +
                "ReservoirReplen1Rate=250\n" +
                "ReservoirReplen1NoCircFactor=1\n" +
                "ReservoirReplen2Enable=false\n" +
                "ReservoirReplen2Chem=test2\n" +
                "ReservoirReplen2TimeBased=false\n" +
                "ReservoirReplen2Rate=250\n" +
                "ReservoirReplen2NoCircFactor=1\n" +
                "ReservoirReplen3Enable=false\n" +
                "ReservoirReplen3Chem=<None>\n" +
                "ReservoirReplen3TimeBased=false\n" +
                "ReservoirReplen3Rate=0\n" +
                "ReservoirReplen3NoCircFactor=1\n" +
                "ReservoirReplen4Enable=false\n" +
                "ReservoirReplen4Chem=<None>\n" +
                "ReservoirReplen4TimeBased=false\n" +
                "ReservoirReplen4Rate=0\n" +
                "ReservoirReplen4NoCircFactor=1\n" +
                "ReservoirReplen5Enable=false\n" +
                "ReservoirReplen5Chem=<None>\n" +
                "ReservoirReplen5TimeBased=false\n" +
                "ReservoirReplen5Rate=0\n" +
                "ReservoirReplen5NoCircFactor=1\n" +
                "ReservoirReplen6Enable=false\n" +
                "ReservoirReplen6Chem=<None>\n" +
                "ReservoirReplen6TimeBased=false\n" +
                "ReservoirReplen6Rate=0\n" +
                "ReservoirReplen6NoCircFactor=1\n" +
                "ReservoirANReplen1Enable=false\n" +
                "ReservoirANReplen1Chem=<None>\n" +
                "ReservoirANReplen1TimeBased=false\n" +
                "ReservoirANReplen1Rate=0\n" +
                "ReservoirANReplen1NoCircFactor=1\n" +
                "ReservoirANReplen2Enable=false\n" +
                "ReservoirANReplen2Chem=<None>\n" +
                "ReservoirANReplen2TimeBased=false\n" +
                "ReservoirANReplen2Rate=0\n" +
                "ReservoirANReplen2NoCircFactor=1\n" +
                "ReservoirANReplen3Enable=false\n" +
                "ReservoirANReplen3Chem=<None>\n" +
                "ReservoirANReplen3TimeBased=false\n" +
                "ReservoirANReplen3Rate=0\n" +
                "ReservoirANReplen3NoCircFactor=1\n" +
                "ReservoirANReplen4Enable=false\n" +
                "ReservoirANReplen4Chem=<None>\n" +
                "ReservoirANReplen4TimeBased=false\n" +
                "ReservoirANReplen4Rate=0\n" +
                "ReservoirANReplen4NoCircFactor=1\n" +
                "ReservoirANReplen5Enable=false\n" +
                "ReservoirANReplen5Chem=<None>\n" +
                "ReservoirANReplen5TimeBased=false\n" +
                "ReservoirANReplen5Rate=0\n" +
                "ReservoirANReplen5NoCircFactor=1\n" +
                "ReservoirANReplen6Enable=false\n" +
                "ReservoirANReplen6Chem=<None>\n" +
                "ReservoirANReplen6TimeBased=false\n" +
                "ReservoirANReplen6Rate=0\n" +
                "ReservoirANReplen6NoCircFactor=1\n" +
                "ReservoirFlowWarningHi=F4 100\n" +
                "ReservoirFlowFaultHi=F4 100\n" +
                "ReservoirBleedLevelSetPoint=F4 200\n" +
                "pHHighFault=F4 18\n" +
                "BurninIdlePeriod=U4 1440\n" +
                "BurninCycles=U4 500\n" +
                "BurninAmpHours=F4 500\n" +
                "BurninStartTime=A <None>\n" +
                "BurninSwitchToMaintenance=Bo 1\n" +
                "BurninWaitIdle=Bo 1\n" +
                "ReservoirANLevelWarningLow=F4 5\n";
        List<Map<String,String>> recipeMapList = new ArrayList<>();
        recipeMapList = killRegularRecipe(regularRecipe);
        for (int i=0;i<recipeMapList.size();i++){
            System.out.print(recipeMapList.get(i)+"\n");
        }

    }

}

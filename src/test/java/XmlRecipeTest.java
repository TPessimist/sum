import org.dom4j.DocumentException;

import java.util.List;
import java.util.Map;


import static dataProcessing.SyXmlUtilsPlus.killXmlPlus;

public class XmlRecipeTest {


    public static void main (String args[]) throws DocumentException {
        String xmlString = "<DEPRecipe xmlns=\"http://schemas.datacontract.org/2004/07/ThunderRecipes\"\n" +
                "           xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <Author i:nil=\"true\" xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\"/>\n" +
                "    <CreationDate xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\">2/28/2020 2:46:03 PM (UTC -5)\n" +
                "    </CreationDate>\n" +
                "    <Description xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\">Default description</Description>\n" +
                "    <PPID xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\">8-X57018B-SNAG25.dep.rcp</PPID>\n" +
                "    <RecipeType xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\">Deposition</RecipeType>\n" +
                "    <SaveDate i:nil=\"true\" xmlns=\"http://schemas.datacontract.org/2004/07/TEN.Common.Components\"/>\n" +
                "    <Chemistry>SnAg</Chemistry>\n" +
                "    <CurrentRampProfileSteps>\n" +
                "        <CurrentRampProfile>\n" +
                "            <CurrentRampDurartionSeconds>120</CurrentRampDurartionSeconds>\n" +
                "            <ForwardAmps>0.193</ForwardAmps>\n" +
                "            <PulseEnabled>false</PulseEnabled>\n" +
                "            <ReverseAmps>0</ReverseAmps>\n" +
                "            <ShearPlateSpeed>100</ShearPlateSpeed>\n" +
                "        </CurrentRampProfile>\n" +
                "        <CurrentRampProfile>\n" +
                "            <CurrentRampDurartionSeconds>690</CurrentRampDurartionSeconds>\n" +
                "            <ForwardAmps>0.386</ForwardAmps>\n" +
                "            <PulseEnabled>false</PulseEnabled>\n" +
                "            <ReverseAmps>0</ReverseAmps>\n" +
                "            <ShearPlateSpeed>100</ShearPlateSpeed>\n" +
                "        </CurrentRampProfile>\n" +
                "    </CurrentRampProfileSteps>\n" +
                "    <CurrentWarningLevel>5</CurrentWarningLevel>\n" +
                "    <CycleClampsMaxTries>1</CycleClampsMaxTries>\n" +
                "    <FaultPercent>10</FaultPercent>\n" +
                "    <PlatingDelaySeconds>5</PlatingDelaySeconds>\n" +
                "    <PulsePowerSupplySteps/>\n" +
                "    <VolatageLimitMax>10</VolatageLimitMax>\n" +
                "    <VolatageLimitMin>0</VolatageLimitMin>\n" +
                "    <VoltageWarningLevel>10</VoltageWarningLevel>\n" +
                "</DEPRecipe>";
        try {
            //test xml to json
//            killXML(xmlString.replace("\n",""));
            List<Map<String,String>> mapList = killXmlPlus(xmlString);
            for(int i =0;i<mapList.size();i++){
                Map s = mapList.get(i);
                System.out.print(s+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        }

}


package codes;


/*
  Some requirements and TODOs for business rule class as well as applet:

    - the user should be able to type in a text and the system will classify
      the text.

      One way of doing this is to have to TextAreas:
      * one for spam messages
      * one for no spams


    - there should be at least two classes (e.g. spam/no spam).

    - the user should be able to define his/her own instances, including
      defining own classes. I.e. just the classes "0", "1" will not do
      (at least not in a more elaborated version). 

    - there should be a possibility to select different examples
      (probably via the <PARAMETER> tag in the applet HTML page).
      This is mainly for showing some different applications. (There are more
      applications than spam classification!)

    - I must find at least one example besides spam/no spam which are easy to do

    BUGS:
    - a boring bug is that some classifiers don't work if the test string
      contains a word not included in the original classifier. Which is not
      that strange if one think about it; but still.
      SOLUTION: put all words in the original model into a a Hash/Set and
      for the test string just check the words contained in the original model.
      But then comes the problem of deciding which class to choose if there is
      no original word in the test string!

      Is there any way of getting the default class from a classifier?

      FIX: I just test the words (model words) that's in the modeling 
      classification.

*/


import java.io.*;
import java.util.*;
import java.text.*;

import weka.core.*;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Attribute;

import weka.classifiers.*;
import weka.classifiers.Classifier;
import weka.classifiers.trees.*;
import weka.classifiers.trees.j48.*;
import weka.classifiers.bayes.*;
import weka.filters.unsupervised.attribute.StringToWordVector;


public class TextClassifier {

    public String[]   inputText       = null;
    
    public String[]   inputClasses    = null;
    public String     classString     = null;
    public static String caseresults = "";
    public Attribute  classAttribute  = null;
    public Attribute  textAttribute   = null;
    public FastVector attributeInfo   = null;
    public Instances  instances       = null;
    public Classifier classifier      = null;
    public Instances  filteredData    = null;
    public Evaluation evaluation      = null;
    public Set        modelWords      = null;
    public static String texttoDisplay = "";
    
    // maybe this should be settable?
    public String     delimitersStringToWordVector = "\\s.,:'\\\"()?!";
    public static String thisClassString = "";
    
    
    //
    // main, mainly for testing
    //
    public static void main(String args[]) {

//         thisClassString = "weka.classifiers.bayes.NaiveBayes";
        //String thisClassString = "weka.classifiers.lazy.IBk";
/*
        if (args.length > 0) {
            thisClassString = args[0];
        } 

        String[] inputText =  {"Good product..", "Product is very good", "product is not good", "Bad product", "worst experience", "nice quality of hardware", "poor performance", "Product is good, but sound quality is poor", "I am satisfied with this product", "I am not satisfied with this product", "Product is satisfacotry", " awesome product", "product is not satisfactory", "better than my previous product", "Best product ever", "Good enough", "product hs some issues", "Not working", "Disappointed with this product", "Simply good", "I am so greatful for thius product", "I like it, Really!!!", "I love it!!!", "Low quality product", "Not happy with this product", "I hate this product", "Excellent product, and great sound", "The best I have found so far", "Brilliant Product", "Very bad quality", "Having software issues", "Having hardware issues"};

        
        String[] inputClasses = {"good", "good", "bad", "bad", "bad", "good", "bad", "bad", "good", "bad", "good", "good", "bad", "good", "good", "good", "bad", "bad", "bad", "good", "good", "good", "good", "bad", "bad", "bad", "good", "good", "good", "bad", "bad", "bad"};
        
        String[] testText = {"Good product..","product is not good", "worst experience","I am not satisfied with this product","nice quality of hardware","poor performance", "Product is good, but sound quality is poor", "I am satisfied with this product", "Product is satisfacotry", "Having hardware issues"};
        
        System.out.println(""+inputText.length+" "+inputClasses.length+ " "+testText.length);
        
        if (inputText.length != inputClasses.length) {
            System.err.println("The length of text and classes must be the same!");
            System.exit(1);
        }
        
        // calculate the classValues
        HashSet classSet = new HashSet(Arrays.asList(inputClasses));
        classSet.add("?");
        String[] classValues = (String[])classSet.toArray(new String[0]);

        //
        // create class attribute
        //
        FastVector classAttributeVector = new FastVector();
        for (int i = 0; i < classValues.length; i++) {
            classAttributeVector.addElement(classValues[i]);
        }
        Attribute thisClassAttribute = new Attribute("class", classAttributeVector);

        //
        // create text attribute
        //
        FastVector inputTextVector = null;  // null -> String type
        Attribute thisTextAttribute = new Attribute("text", inputTextVector);
        for (int i = 0; i < inputText.length; i++) {
            thisTextAttribute.addStringValue(inputText[i]);
        }
        
        // add test cases (to be inserted into instances)
        // just a singular test string
        
        String newTextString = newTestTextField.getText();
        String[] newTextArray = new String[1];
        newTextArray[0] = newTextString;
        if (!"".equals(newTextString)) {
            thisTextAttribute.addStringValue(newTextString);
        }
        

        // add the text of test cases
        for (int i = 0; i < testText.length; i++) {
            thisTextAttribute.addStringValue(testText[i]);
        }

        //
        // create the attribute information
        //
        FastVector thisAttributeInfo = new FastVector(2);
        thisAttributeInfo.addElement(thisTextAttribute);
        thisAttributeInfo.addElement(thisClassAttribute);


        TextClassifier classifier = new TextClassifier(inputText, inputClasses, thisAttributeInfo, thisTextAttribute, thisClassAttribute, thisClassString);

        System.out.println("DATA SET:\n");
        System.out.println(classifier.classify(thisClassString));

        System.out.println("NEW CASES:\n");
        System.out.println(classifier.classifyNewCases(testText));*/


    } // end main


    //
    // constructor
    //
    public TextClassifier(String[] inputText, String[] inputClasses, FastVector attributeInfo, Attribute textAttribute, Attribute classAttribute, String classString) {
        this.inputText      = inputText;
        this.inputClasses   = inputClasses;
        this.classString    = classString;
        this.attributeInfo  = attributeInfo;
        this.textAttribute  = textAttribute;
        this.classAttribute = classAttribute;

        

    }



    // 
    // make classification and everything
    // 
    public StringBuffer classify() {

        if (classString == null || "".equals(classString)) {
            return(new StringBuffer());
        }

        return classify(classString);

    } // end classify()


    
    //
    // the real classify method
    //
    public StringBuffer classify(String classString) {
        
        this.classString = classString;

        StringBuffer result = new StringBuffer();

        // creates an empty instances set
        instances = new Instances("data set", attributeInfo, 100);

        // set which attribute is the class attribute
        instances.setClass(classAttribute);


        try {

            instances = populateInstances(inputText, inputClasses, instances, classAttribute, textAttribute);
           // result.append("DATA SET:\n" + instances + "\n");

            // make filtered SparseData
            filteredData = filterText(instances);

            // create Set of modelWords
            modelWords = new HashSet();
            Enumeration enumx = filteredData.enumerateAttributes();
            while (enumx.hasMoreElements()) {
                Attribute att = (Attribute)enumx.nextElement();
                String attName = att.name().toLowerCase();
                modelWords.add(attName);
                
            }
 
            //
            // Classify and evaluate data
            //
            classifier = Classifier.forName(classString,null);

            classifier.buildClassifier(filteredData);
            evaluation = new Evaluation(filteredData);
            evaluation.evaluateModel(classifier, filteredData);

            


            result.append(printClassifierAndEvaluation(classifier, evaluation) + "\n");

            // check instances
            int startIx = 0;
            result.append(checkCases(filteredData, classifier, classAttribute, inputText, "not test", startIx)  + "\n");


        } catch (Exception e) {
            e.printStackTrace();
            result.append("\nException (sorry!):\n" + e.toString());
        }

        return result;

    } // end classify


    //
    // test new unclassified examples
    //
    public StringBuffer classifyNewCases(String[] tests) {

        StringBuffer result = new StringBuffer();

        // 
        // first copy the old instances, 
        // then add the test words
        //

        Instances testCases = new Instances(instances);
        testCases.setClass(classAttribute);


        //
        // since some classifiers cannot handle unknown words (i.e. words not
        // a 'model word'), we filter these unknowns out.
        // Maybe this should be done only for those classifiers?
        // E.g. Naive Bayes have prior probabilities which may be used?
        // 
        // Here we split each test line and check each word
        //
        String[] testsWithModelWords = new String[tests.length];
        int gotModelWords = 0; // how many words will we use?

        for (int i = 0; i < tests.length; i++) {
            // the test string to use
            StringBuffer acceptedWordsThisLine = new StringBuffer();

            // split each line in the test array
            String[] splittedText = tests[i].split("["+delimitersStringToWordVector+"]");
            // check if word is a model word
            for (int wordIx = 0; wordIx < splittedText.length; wordIx++) {
                String sWord = splittedText[wordIx];
                if (modelWords.contains((String)sWord)) {
                    gotModelWords++;
                    acceptedWordsThisLine.append(sWord + " ");
                }
            }
            testsWithModelWords[i] = acceptedWordsThisLine.toString();
        }


        // should we do do something if there is no modelWords?
        if (gotModelWords == 0) {
            result.append("\nWarning!\nThe text to classify didn't contain a single\nword from the modelled words. This makes it hard for the classifier to\ndo something usefull.\nThe result may be weird.\n\n");
        }

        try {

            // add the ? class for all test cases
            String[] tmpClassValues = new String[tests.length];
            for (int i = 0; i < tmpClassValues.length; i++) {
                tmpClassValues[i] = "neutral";
            }

            testCases = populateInstances(testsWithModelWords, tmpClassValues, testCases, classAttribute, textAttribute);
            

            // result.append("TEST CASES before filter:\n" + testCases + "\n");

            Instances filteredTests = filterText(testCases);

            // result.append("TEST CASES:\n" + filteredTests + "\n");
        
            //
            // check
            //
            int startIx = instances.numInstances();
            result.append(checkCases(filteredTests, classifier, classAttribute, tests, "newcase", startIx) + "\n");

        } catch (Exception e) {
            e.printStackTrace();
            result.append("\nException (sorry!):\n" + e.toString());
        }

        return result;

    } //  end classifyNewCases


    //
    //  from empty instances populate with text and class arrays
    //
    public static Instances populateInstances(String[] theseInputTexts, String[] theseInputClasses, Instances theseInstances, Attribute classAttribute, Attribute textAttribute) {

        for (int i = 0; i < theseInputTexts.length; i++) {
            Instance inst = new Instance(2);
            inst.setValue(textAttribute,theseInputTexts[i]);
            if (theseInputClasses != null && theseInputClasses.length > 0) {
                inst.setValue(classAttribute, theseInputClasses[i]);
            }
            theseInstances.add(inst);
        }

        return theseInstances;


    } // populateInstances


    //
    // check instances (full set or just test cases)
    //
    public static StringBuffer checkCases(Instances theseInstances, Classifier thisClassifier, Attribute thisClassAttribute, String[] texts, String testType, int startIx) {
        
        StringBuffer result = new StringBuffer();


        try {

            result.append("\nCHECKING ALL THE INSTANCES:\n");

            Enumeration enumClasses = thisClassAttribute.enumerateValues();
            result.append("Class values (in order): ");
            while (enumClasses.hasMoreElements()) {
                String classStr = (String)enumClasses.nextElement();
                result.append("'" + classStr + "'  ");
            }
            result.append("\n");
            // startIx is a fix for handling text cases
            for (int i = startIx; i < theseInstances.numInstances(); i++) {

                SparseInstance sparseInst = new SparseInstance(theseInstances.instance(i));
                sparseInst.setDataset(theseInstances);

                result.append("\nTesting: '" + texts[i-startIx] + "'\n");
                // result.append("SparseInst: " + sparseInst + "\n");

                double correctValue = (double)sparseInst.classValue();
                double predictedValue = thisClassifier.classifyInstance(sparseInst);

                if("newcase".equals(testType))
                {
                	caseresults += thisClassAttribute.value((int)predictedValue) + ",";
                }
                
                
                String predictString = thisClassAttribute.value((int)predictedValue) + " (" + predictedValue + ")";
                
                result.append("predicted: '" + predictString);
                
                // print comparison if not new case
                if (!"newcase".equals(testType)) {
                    String correctString = thisClassAttribute.value((int)correctValue) + " (" + correctValue + ")";
                    String testString = ((predictedValue == correctValue) ? "OK!" : "NOT OK!") + "!";
                    result.append("' real class: '" + correctString +  "' ==> " +  testString + "\n");
                }
                result.append("\n");

                /*
                if (thisClassifier instanceof Distribution) {
                double[] dist = ((Distribution)thisClassifier).distributionForInstance(sparseInst);
                    
                    // weight the levels into a spamValue
                    double weightedValue = 0; // experimental
                    result.append("probability distribution:\n");
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(3);
                    for (int j = 0; j < dist.length; j++) {
                        result.append(nf.format(dist[j]) + " ");
                        weightedValue += 10*(j+1)*dist[j];
                        if (j < dist.length -1) {
                            result.append(",  ");
                        }
                    }
                    result.append("\nWeighted Value: " + nf.format(weightedValue) + "\n");
                }
                */
              
                result.append("\n");
                // result.append(thisClassifier.dumpDistribution());
                // result.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.append("\nException (sorry!):\n" + e.toString());
        }
        
        return result;

    } // end checkCases


    //
    // take instances in normal format (strings) and convert to Sparse format
    //
    public static Instances filterText(Instances theseInstances) {

        StringToWordVector filter = null;
        // default values according to Java Doc:
        int wordsToKeep = 1000;

        Instances filtered = null;

        try {

            filter = new StringToWordVector(wordsToKeep);
            // we ignore this for now...
            // filter.setDelimiters(delimitersStringToWordVector);
            filter.setOutputWordCounts(true);
            filter.setSelectedRange("1");
            
            filter.setInputFormat(theseInstances);
            
            filtered = weka.filters.Filter.useFilter(theseInstances,filter);
            // System.out.println("filtered:\n" + filtered);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return filtered;
        
    } // end filterText


    //
    // information about classifier and evaluation
    //
    public static StringBuffer printClassifierAndEvaluation(Classifier thisClassifier, Evaluation thisEvaluation) {

        StringBuffer result = new StringBuffer();

        try {
            result.append("\n\nINFORMATION ABOUT THE CLASSIFIER AND EVALUATION:\n");
            result.append("\nclassifier.toString():\n" + thisClassifier.toString() + "\n");
            result.append("\nevaluation.toSummaryString(title, false):\n" + thisEvaluation.toSummaryString("Summary",false)  + "\n");
            result.append("\nevaluation.toMatrixString():\n" + thisEvaluation.toMatrixString()  + "\n");
            result.append("\nevaluation.toClassDetailsString():\n" + thisEvaluation.toClassDetailsString("Details")  + "\n");
            result.append("\nevaluation.toCumulativeMarginDistribution:\n" + thisEvaluation.toCumulativeMarginDistributionString()  + "\n");
            
            
            double [][]confusionMatrix = thisEvaluation.confusionMatrix();
			double tp = confusionMatrix[0][0];
			double tn = confusionMatrix[1][1];
			double accuracy = (tp + tn) / 1000;
			double precision = thisEvaluation.weightedPrecision() * 100;
			double recall = thisEvaluation.weightedRecall() * 100;
			
			
			if(thisClassString.equals("weka.classifiers.lazy.IBk"))
			{
				ComparisonParameters.setKtp(tp);
				ComparisonParameters.setKtn(tn);
				ComparisonParameters.setKaccuracy(accuracy);
				ComparisonParameters.setKprecision(precision);
				ComparisonParameters.setKrecall(recall);
			}
			else
				if(thisClassString.equals("weka.classifiers.bayes.NaiveBayes"))
				{
					ComparisonParameters.setNtp(tp);
					ComparisonParameters.setNtn(tn);
					ComparisonParameters.setNaccuracy(accuracy);
					ComparisonParameters.setNprecision(precision);
					ComparisonParameters.setNrecall(recall);
				}
        } catch (Exception e) {
            e.printStackTrace();
            result.append("\nException (sorry!):\n" + e.toString());
        }

        return result;

    } // end printClassifierAndEvaluation



    //
    // setter for the classifier _string_
    //
    public void setClassifierString(String classString) {
        this.classString = classString;
    }
    

} // end class TextClassifier

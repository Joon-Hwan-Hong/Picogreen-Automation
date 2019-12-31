# Picogreen DNA Quantification Analysis Automation
#### [By Joon Hwan Hong](https://github.com/Joon-Hwan-Hong "My Github Page!")

## Introduction
Picogreen DNA quantification protocol is a method to quantify DNA in samples. DNA samples were obtained from post-mortem human brain tissue at the Douglas Mental Health University Institute. Samples were diluted and placed into 96-well plates, which was quantified in the TECAN Spark reader using a modified PicoGreen protocol.

I made this repository as it was annoying to do it by hand every time on excel. Saves time and why not make it as a personal project in using pandas and excel manipulations. The notebook accounts for the plate layout including triple copy of the Standard DNA curve and the DNA sample slots. (3 wells per sample/DNA curve). Currently the notebook requires that the plate layout file and the results sheet to be on the same directory, will be improved later.

Some excel data is included in repository, however all irrelevant information in them was removed for potential privacy concerns.

## How to use
1. Put the jupyter notebook and two separate excel files (one generated from TECAN Spark reader for Picogreen and the protocol plate layout) into the same directory/ folder.
> Example of plate layout is shown below and on the repository. Position of standard DNA curve chosen arbitrarily
> ![alt text](Layout_Example.png "Layout_Example")
4. Go to <<Misc. and Settings>> to change parameters (need to change the name of layout and tecan excel file) 
3. Click "Cell" on the Menu bar, then click "Run All"
4. The report should be generated in the same directory / folder

### Function & Development Plan
The notebook achieves the following:
1. Display plate layout and the individual quantification recordings of each 96 well slots 
2. Determine the average value for each DNA sample
3. Determine the concentration for each DNA sample
4. Visualize the data obtained
5. Create a new summarized excel sheet containing all the data, and maybe inclue metadata from the results sheet as well, visualizations in one nice excel file with multiple sheets (Partial)
6. Detect extreme/ "odd recordings" and exclude from calculations (TBD)

If there are any questions on the code, feel free to [email me](mailto:joon.hong@mail.mcgill.ca)

//
//  FormViewController.m
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import "FormViewController.h"

#define BUTTONLOGIN 0

@interface FormViewController ()

@end

@implementation FormViewController

    UITextField *firstNameTextField;
    UITextField *lastNameTextField;
    UITextField *ageTextField;
    UIButton *addButton;

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    firstNameTextField = [[UITextField alloc] initWithFrame:CGRectMake(250.0, 30, 240.0, 40.0)]; //Start of the login text field
    
        if(firstNameTextField !=nil)
        {
            firstNameTextField.borderStyle = UITextBorderStyleRoundedRect;
        }
    [self.view addSubview:firstNameTextField];
    
    
    lastNameTextField = [[UITextField alloc] initWithFrame:CGRectMake(250.0, 30, 240.0, 40.0)]; //Start of the login text field
    
        if(lastNameTextField !=nil)
        {
            lastNameTextField.borderStyle = UITextBorderStyleRoundedRect;
        }
    [self.view addSubview:lastNameTextField];
    
    
    ageNameTextField = [[UITextField alloc] initWithFrame:CGRectMake(250.0, 30, 240.0, 40.0)]; //Start of the login text field
    
        if(ageNameTextField !=nil)
        {
            ageNameTextField.borderStyle = UITextBorderStyleRoundedRect;
        }
    [self.view addSubview:ageNameTextField];
    
    addButton = [UIButton buttonWithType:UIButtonTypeRoundedRect]; //Start of the login button
    
        if(addButton !=nil)
        {
            addButton.frame = CGRectMake(300.0, 90.0, 110.0, 40.0);
            [addButton setTitle:@"Add" forState:UIControlStateNormal];
            [addButton setTitle:@"Adding" forState:UIControlStateHighlighted];
            [addButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
            addButton.tag = BUTTONLOGIN;
        }
    [self.view addSubview:addButton];
}

- (void)onClick:(UIButton*) addButton
{
    if(addButton.tag == BUTTONLOGIN) //if for the username button
    {
        NSString *userNameText = [addButton text];
        
        if(userNameText.length > 0)
        {

        }
        
        else
        {
            
        }
        
    }//End of checks for button
    
}//End of onClick

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end

//
//  DetailViewController.m
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import "DetailViewController.h"

#define BUTTONDELETE 0

@interface DetailViewController ()

@end

@implementation DetailViewController

@synthesize firstName;
@synthesize lastName;
@synthesize age;

    IBOutlet UILabel *firstNameLabel;
    IBOutlet UILabel *lastNameLabel;
    IBOutlet UILabel *ageLabel;
    IBOutlet UIButton *deleteButton;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self)
    {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    firstNameLabel = [[UILabel alloc] initWithFrame:CGRectMake(130.0, 160.0, 500.0, 60.0)];
    
        if(firstNameLabel !=nil)
        {
            firstNameLabel.textColor = [UIColor blackColor];
            firstNameLabel.textAlignment = NSTextAlignmentCenter;
        }
        [self.view addSubview:firstNameLabel];
    
    lastNameLabel = [[UILabel alloc] initWithFrame:CGRectMake(130.0, 160.0, 500.0, 60.0)];
    
        if(lastNameLabel !=nil)
        {
            lastNameLabel.textColor = [UIColor blackColor];
            lastNameLabel.textAlignment = NSTextAlignmentCenter;
        }
        [self.view addSubview:lastNameLabel];
    
    ageLabel = [[UILabel alloc] initWithFrame:CGRectMake(130.0, 160.0, 500.0, 60.0)];
    
        if(ageLabel !=nil)
        {
            ageLabel.textColor = [UIColor blackColor];
            ageLabel.textAlignment = NSTextAlignmentCenter;
        }
        [self.view addSubview:ageLabel];
    
    deleteButton = [UIButton buttonWithType:UIButtonTypeRoundedRect]; //Start of the date button
    
        if(deleteButton !=nil)
        {
            deleteButton.frame = CGRectMake(300.0, 350.0, 110.0, 40.0);
            [deleteButton setTitle:@"Delete" forState:UIControlStateNormal];
            [deleteButton setTitle:@"Deleting" forState:UIControlStateHighlighted];
            [deleteButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        }
        [self.view addSubview:deleteButton];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)updateUILabel
{
    firstNameLabel.text = firstName;
    lastNameLabel.text = lastName;
    ageLabel.text = age;
}

- (void)onClick:(UIButton*) deleteButton
{
    if(deleteButton.tag == BUTTONDELETE) //if for the username button
    {
        
//        if(userNameText.length > 0)
//        {
//            
//        }
//        
//        else
//        {
//            
//        }
        
    }//End of checks for button
    
}//End of onClick


@end

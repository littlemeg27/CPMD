//
//  ListViewController.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ListViewController : UIViewController
{
    IBOutlet UITableView *tableView;
    
    NSMutableArray *firstNameArray;
    NSMutableArray *lastNameArray;
    NSMutableArray *ageArray;
}
@end

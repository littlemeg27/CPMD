//
//  ListViewCell.h
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ListViewCell : UITableViewCell
{
    IBOutlet UILabel *firstNameLabel;
}

@property (nonatomic, strong) UILabel* firstNameLabel;

@end

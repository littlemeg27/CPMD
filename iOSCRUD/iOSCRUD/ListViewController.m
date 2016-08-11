//
//  ListViewController.m
//  iOSCRUD
//
//  Created by Brenna Pavlinchak on 8/8/16.
//  Copyright © 2016 Brenna Pavlinchak. All rights reserved.
//

#import "ListViewController.h"
#import "DetailViewController.h"

@interface ListViewController ()

@end

@implementation ListViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    UINib *customCellNib = [UINib nibWithNibName:@"CustomCellView" bundle:nil];
    
    if(customCellNib !=nil)
    {
        [tableView registerNib:customCellNib forCellReuseIdentifier:@"ListViewCell"];
    }
}

- (UITableViewCellEditingStyle)tableView:(UITableView *)tableView editingStyleForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return UITableViewCellEditingStyleDelete;
}
                 
                 
-(void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath //We need this to do the editing of our tableView
{
    if (editingStyle == UITableViewCellEditingStyleDelete)
    {
        NSLog(@"I want to delete: %d", indexPath.row);
            
        [firstNameArray removeObjectAtIndex:indexPath.row];
            
        [tableView deleteRowsAtIndexPaths:[NSMutableArray arrayWithObject:indexPath] withRowAnimation:TRUE];
    }
}
                 
                 
-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section //Creates table view
{
        return [firstNameArray count];
}
                 
-(UITableViewCell *)tableView:(UITableView *)tableView2 cellForRowAtIndexPath:(NSIndexPath *)indexPath //Adds values to each row
{
    static NSString  *cellIdentity = @"ListViewCell";
        
    UITableViewCell *cellRow  = [tableView dequeueReusableCellWithIdentifier: cellIdentity];
        
        
    if(cellRow == nil)
    {
        cellRow = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier: cellIdentity];
    }
        
    cellRow.textLabel.text = [firstNameArray objectAtIndex:indexPath.row]; //Show the name on the table
        
    return cellRow;
}
                 
                 
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath;
{
    DetailViewController *detailView = [[DetailViewController alloc] initWithNibName:@"DetailView" bundle:nil]; //Pop to the detail page
        
    if(detailView !=nil)
    {
        detailView.name = [crudArray objectAtIndex:indexPath.row]; //Show the name on the detail page
        [self presentViewController:detailView animated:YES completion:nil];
        [detailView updateUILabel];
    }
}
                 
-(CGFloat)tableView:(UITableViewCell *)sender heightForRowAtIndexPath:(NSIndexPath *)indexPath; //Changes the height of the cells to the right size.
{
        return tableView.rowHeight * 1.5;
}

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

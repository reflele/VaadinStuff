package com.example.application.views.components.tripview;

import com.example.application.Goal;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;


@PageTitle("Trip view")
@Route(value = "trip", layout = MainLayout.class)
public class TripView extends HorizontalLayout {

    private TextField goal;
    private IntegerField achievement;
    private TextField gap;
    private Button button;
    private Goal goalObject;
    private ArrayList<Goal> goalsList;
    private Grid<Goal> grid;



    public TripView(){
        goal = new TextField("goal");
        achievement = new IntegerField("achievement");
        achievement.setHelperText("rate the achievement from 1-8");
        achievement.setMin(1);
        achievement.setMax(8);
        achievement.setValue(4);
        achievement.setHasControls(true);
        gap = new TextField("gap");
        button = new Button("+ add goal");
        goalsList = new ArrayList<>();
        button.addClickListener(e -> {
            goalObject = new Goal(goal.getValue(),achievement.getValue(),gap.getValue());
            makeTableEntry(goalObject);
        });

        button.addClickShortcut(Key.ENTER);

        grid = new Grid<>(Goal.class, false);
        grid.addColumn(Goal::getGoal).setHeader("Goal");
        grid.addColumn(Goal::getAchievement).setHeader("Achievement");
        grid.addColumn(Goal::getGap).setHeader("Gap");






        VerticalLayout vertical = new VerticalLayout();

        Div div = new Div();
        div.add(goal,achievement,gap);
        vertical.add(div);
        vertical.add(button);
        vertical.add(grid);


        add(vertical);
    }
    private void makeTableEntry(Goal goal){
        Notification.show(goal.getGoal() + " has been added as a goal");
        goalsList.add(goal);
        grid.setItems(goalsList);

    }
}

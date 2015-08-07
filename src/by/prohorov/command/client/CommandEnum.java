package by.prohorov.command.client;

import by.prohorov.command.*;
import by.prohorov.command.delete.*;

public enum CommandEnum {
    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    },
    DOREGISTER{
        {
            this.command = new RegisterCommand();
        }
    },
    REGISTER{
        {
            this.command = new DoRegisterCommand();
        }
    },
    CREATE {
        {
            this.command = new CreateNoteCommand();
        }
    },
    CREATENOTE{
        {
            this.command = new AddNoteCommand();
        }
    },
    ADD{
        {
            this.command = new GoAddCommand();
        }
    },
    GOMAIN{
        {
            this.command = new GoMainCommand();
        }
    },
    DELETE1{
        {
            this.command = new DeleteNoteCommand1();
        }
    },
    DELETE2{
        {
            this.command = new DeleteNoteCommand2();
        }
    },
    DELETE3{
        {
            this.command = new DeleteNoteCommand3();
        }
    },
    DELETE4{
        {
            this.command = new DeleteNoteCommand4();
        }
    },
    DELETE5{
        {
            this.command = new DeleteNoteCommand5();
        }
    },
    DELETE6{
        {
            this.command = new DeleteNoteCommand6();
        }
    },
    DELETE7{
        {
            this.command = new DeleteNoteCommand7();
        }
    },
    DELETE8{
        {
            this.command = new DeleteNoteCommand8();
        }
    },
    DELETE9{
        {
            this.command = new DeleteNoteCommand9();
        }
    },
    DELETE10{
        {
            this.command = new DeleteNoteCommand10();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}

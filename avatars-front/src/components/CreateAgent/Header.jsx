import HeaderButton from "./HeaderButton";
import close from '../../assets/close.png';

export default function Header({ currentStage, setCurrentStage }) {
    return (
        <header className="progress-header">
            <span>New Agent</span>
            <div className="progress-layer1">
                <div className="progress-layer2">
                    <div className="progress-layer3">
                        <HeaderButton
                            activeButtonName={currentStage}
                            onButtonClick={setCurrentStage}
                            title='Appearance'
                        />
                        <HeaderButton
                            activeButtonName={currentStage}
                            onButtonClick={setCurrentStage}
                            title='Characteristics'
                        />
                        <HeaderButton
                            activeButtonName={currentStage}
                            onButtonClick={setCurrentStage}
                            title='Knowledge Sources'
                        />
                        <HeaderButton
                            activeButtonName={currentStage}
                            onButtonClick={setCurrentStage}
                            title='Finish'
                        />
                    </div>
                </div>
            </div>
            <button className="close-button">
                <img src={close} />
            </button>
        </header>
    );
}
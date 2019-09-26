package com.zathrox.explorercraft.client.model;


import com.zathrox.explorercraft.common.entity.WizardEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.util.math.MathHelper;

public class WizardModel extends EntityModel
{
	public RendererModel leftEyebrow;
	public RendererModel rightEyebrow;
	public RendererModel hair1;
	public RendererModel hair2;
	public RendererModel wizardHead;
	public RendererModel wizardLeftArm;
	public RendererModel wizardNose;
	public RendererModel wizardRightArm;
	public RendererModel wizardBody;
	public RendererModel wizardLegLeft;
	public RendererModel wizardLegRight;
	public RendererModel Hat_1;
	public RendererModel Hat_2;
	public RendererModel Hat_3;
	public RendererModel Hat_4;
	public RendererModel Beard_1;
	public RendererModel Beard_2;
	public RendererModel Beard_3;
	public RendererModel Beard_4;
	public RendererModel Beard_5;
	public RendererModel Beard_6;
	public RendererModel Beard_7;
	public RendererModel Staff_1;
	public RendererModel Staff_2;
	public RendererModel Staff_3;
	public RendererModel Staff_4;
	public RendererModel Staff_5;
	
	public WizardModel()
	{
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.hair1 = new RendererModel(this, 48, 27);
        this.hair1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair1.addBox(-3.0F, -7.0F, 3.0F, 6, 7, 2, 0.0F);
        this.Staff_5 = new RendererModel(this, 48, 43);
        this.Staff_5.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.Staff_5.addBox(0.0F, -6.3F, -9.0F, 2, 2, 2, 0.0F);
        this.Beard_3 = new RendererModel(this, 44, 0);
        this.Beard_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_3.addBox(-4.0F, -1.0F, -5.0F, 8, 6, 2, 0.0F);
        this.Staff_4 = new RendererModel(this, 40, 44);
        this.Staff_4.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.Staff_4.addBox(0.0F, -5.9F, 10.7F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Staff_4, 2.1642082724729685F, 0.0F, 0.0F);
        this.hair2 = new RendererModel(this, 48, 27);
        this.hair2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hair2.addBox(-3.0F, 0.0F, 3.0F, 6, 7, 2, 0.0F);
        this.Staff_1 = new RendererModel(this, 56, 43);
        this.Staff_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Staff_1.addBox(-3.0F, 3.0F, -8.0F, 2, 19, 2, 0.0F);
        this.setRotateAngle(Staff_1, 0.8754571528003554F, 0.0F, -0.017453292519943295F);
        this.Beard_5 = new RendererModel(this, 32, 8);
        this.Beard_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_5.addBox(1.0F, -3.0F, -5.0F, 4, 1, 4, 0.0F);
        this.leftEyebrow = new RendererModel(this, 0, 8);
        this.leftEyebrow.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftEyebrow.addBox(0.5F, -5.0F, -5.0F, 4, 1, 1, 0.0F);
        this.Staff_2 = new RendererModel(this, 48, 54);
        this.Staff_2.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.Staff_2.addBox(0.0F, -4.5F, -7.5F, 2, 8, 2, 0.0F);
        this.setRotateAngle(Staff_2, -0.33161255787892263F, 0.0F, 0.0F);
        this.Beard_2 = new RendererModel(this, 48, 8);
        this.Beard_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_2.addBox(-3.0F, 5.0F, -5.0F, 6, 3, 2, 0.0F);
        this.wizardLegRight = new RendererModel(this, 0, 64);
        this.wizardLegRight.setRotationPoint(-2.0F, 13.0F, 0.0F);
        this.wizardLegRight.addBox(-2.0F, 0.0F, -3.0F, 4, 11, 6, 0.0F);
        this.Hat_3 = new RendererModel(this, 16, 18);
        this.Hat_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat_3.addBox(-2.0F, -14.0F, -7.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(Hat_3, -0.5410521030426025F, 0.0F, 0.0F);
        this.Beard_1 = new RendererModel(this, 36, 4);
        this.Beard_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_1.addBox(-1.0F, 8.0F, -5.0F, 2, 2, 2, 0.0F);
        this.wizardLeftArm = new RendererModel(this, 0, 18);
        this.wizardLeftArm.setRotationPoint(4.1F, 2.0F, -1.0F);
        this.wizardLeftArm.addBox(0.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(wizardLeftArm, 0.0F, 0.0F, -4.960524086056721E-16F);
        this.Beard_6 = new RendererModel(this, 32, 0);
        this.Beard_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_6.addBox(-5.0F, -2.0F, -5.0F, 3, 1, 3, 0.0F);
        this.wizardNose = new RendererModel(this, 24, 0);
        this.wizardNose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wizardNose.addBox(-1.0F, -3.0F, -6.0F, 2, 3, 2, 0.0F);
        this.Staff_3 = new RendererModel(this, 48, 47);
        this.Staff_3.setRotationPoint(-3.0F, 2.0F, 0.0F);
        this.Staff_3.addBox(0.0F, -11.0F, 2.7F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Staff_3, 1.0821041362364843F, 0.0F, 0.0F);
        this.Hat_4 = new RendererModel(this, 16, 27);
        this.Hat_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat_4.addBox(-1.0F, -15.0F, -11.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(Hat_4, -0.9948377013206482F, 0.0F, 0.0F);
        this.rightEyebrow = new RendererModel(this, 0, 8);
        this.rightEyebrow.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightEyebrow.addBox(-4.5F, -5.0F, -5.0F, 4, 1, 1, 0.0F);
        this.wizardBody = new RendererModel(this, 36, 64);
        this.wizardBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wizardBody.addBox(-4.0F, 0.0F, -3.0F, 8, 13, 6, 0.0F);
        this.Hat_1 = new RendererModel(this, 0, 51);
        this.Hat_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat_1.addBox(-6.0F, -8.0F, -6.0F, 12, 1, 12, 0.0F);
        this.wizardLegLeft = new RendererModel(this, 0, 64);
        this.wizardLegLeft.setRotationPoint(2.0F, 13.0F, -1.0F);
        this.wizardLegLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 6, 0.0F);
        this.wizardRightArm = new RendererModel(this, 0, 18);
        this.wizardRightArm.setRotationPoint(-4.0F, 2.0F, 0.0F);
        this.wizardRightArm.addBox(-4.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(wizardRightArm, -0.9105382707654417F, 0.0F, 0.0F);
        this.Beard_4 = new RendererModel(this, 32, 8);
        this.Beard_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_4.addBox(-5.0F, -3.0F, -5.0F, 4, 1, 4, 0.0F);
        this.Beard_7 = new RendererModel(this, 32, 0);
        this.Beard_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Beard_7.addBox(2.0F, -2.0F, -5.0F, 3, 1, 3, 0.0F);
        this.Hat_2 = new RendererModel(this, 0, 40);
        this.Hat_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Hat_2.addBox(-4.0F, -11.0F, -6.0F, 8, 3, 8, 0.0F);
        this.setRotateAngle(Hat_2, -0.27925270795822144F, 0.0F, 0.0F);
        this.wizardHead = new RendererModel(this, 0, 0);
        this.wizardHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wizardHead.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.wizardRightArm.addChild(this.Staff_1);
        this.Staff_1.addChild(this.Staff_5);
        this.Staff_1.addChild(this.Staff_4);
        this.Staff_1.addChild(this.Staff_2);
        this.Staff_1.addChild(this.Staff_3);
        
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.hair1.render(scale);
        this.Beard_3.render(scale);
        this.hair2.render(scale);
        this.Beard_5.render(scale);
        this.leftEyebrow.render(scale);
        this.Beard_2.render(scale);
        this.wizardLegRight.render(scale);
        this.Hat_3.render(scale);
        this.Beard_1.render(scale);
        this.wizardLeftArm.render(scale);
        this.Beard_6.render(scale);
        this.wizardNose.render(scale);
        this.Hat_4.render(scale);
        this.rightEyebrow.render(scale);
        this.wizardBody.render(scale);
        this.Hat_1.render(scale);
        this.wizardLegLeft.render(scale);
        this.wizardRightArm.render(scale);
        this.Beard_4.render(scale);
        this.Beard_7.render(scale);
        this.Hat_2.render(scale);
        this.wizardHead.render(scale);
	}
	
	private void setRotateAngle(RendererModel model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
        boolean shakingHead = false;
        WizardEntity wizard = (WizardEntity)entityIn;
        if (wizard instanceof AbstractVillagerEntity) {
            shakingHead = wizard.getShakeHeadTicks() > 0;
        }
		wizardHead.rotateAngleY = netHeadYaw * 0.017453292F;
        wizardHead.rotateAngleX = headPitch * 0.017453292F;
        if (shakingHead) {
            this.wizardHead.rotateAngleZ = 0.3F * MathHelper.sin(0.45F * ageInTicks);
            this.wizardHead.rotateAngleX = 0.4F;
        } else {
            this.wizardHead.rotateAngleZ = 0.0F;
        }

        this.wizardBody.rotateAngleY = 0.0f;
        Hat_1.rotateAngleX = 0F + wizardHead.rotateAngleX;
		Hat_2.rotateAngleX = -0.2792527F + wizardHead.rotateAngleX;
		Hat_3.rotateAngleX = -0.5410521F + wizardHead.rotateAngleX;
		Hat_4.rotateAngleX = -0.9948377F + wizardHead.rotateAngleX;
		
		Hat_1.rotateAngleY = wizardHead.rotateAngleY;
		Hat_2.rotateAngleY = wizardHead.rotateAngleY;
		Hat_3.rotateAngleY = wizardHead.rotateAngleY;
		Hat_4.rotateAngleY = wizardHead.rotateAngleY;
        
        Beard_1.rotateAngleX = wizardHead.rotateAngleX;
        Beard_2.rotateAngleX = wizardHead.rotateAngleX;
        Beard_3.rotateAngleX = wizardHead.rotateAngleX;
        Beard_4.rotateAngleX = wizardHead.rotateAngleX;
        Beard_5.rotateAngleX = wizardHead.rotateAngleX;
        Beard_6.rotateAngleX = wizardHead.rotateAngleX;
        Beard_7.rotateAngleX = wizardHead.rotateAngleX;
        Beard_1.rotateAngleY = wizardHead.rotateAngleY;
        Beard_2.rotateAngleY = wizardHead.rotateAngleY;
        Beard_3.rotateAngleY = wizardHead.rotateAngleY;
        Beard_4.rotateAngleY = wizardHead.rotateAngleY;
        Beard_5.rotateAngleY = wizardHead.rotateAngleY;
        Beard_6.rotateAngleY = wizardHead.rotateAngleY;
        Beard_7.rotateAngleY = wizardHead.rotateAngleY;
        
        hair1.rotateAngleY = wizardHead.rotateAngleY;
        hair1.rotateAngleX = wizardHead.rotateAngleX;
        hair2.rotateAngleY = wizardHead.rotateAngleY;
        hair2.rotateAngleX = wizardHead.rotateAngleX;
        
        leftEyebrow.rotateAngleY = wizardHead.rotateAngleY;
        leftEyebrow.rotateAngleX = wizardHead.rotateAngleX;
        rightEyebrow.rotateAngleY = wizardHead.rotateAngleY;
        rightEyebrow.rotateAngleX = wizardHead.rotateAngleX;
        leftEyebrow.rotateAngleZ = wizardHead.rotateAngleZ;
        rightEyebrow.rotateAngleZ = wizardHead.rotateAngleZ;
        leftEyebrow.offsetX = 0;
        rightEyebrow.offsetX = 0;
        
        wizardNose.rotateAngleY = wizardHead.rotateAngleY;
        wizardNose.rotateAngleX = wizardHead.rotateAngleX;
		
        float armRotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        
        wizardRightArm.rotateAngleX = -0.8726646F + armRotateAngleX;
        wizardRightArm.rotateAngleZ = 0.0F;
        wizardRightArm.rotateAngleY = 0.0F;
        
        wizardLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        wizardLeftArm.rotateAngleZ = 0.0F;
        wizardLeftArm.rotateAngleY = 0.0F;
        
        
		this.Staff_1.rotateAngleX = -5.4F;
		this.Staff_1.rotateAngleY = 0f;
		this.Staff_1.rotateAngleZ = 0f;
		this.Staff_1.offsetZ = 0.00f;
		this.Staff_1.offsetX = 0.00f;

        
        wizardLegRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        wizardLegLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        wizardLegRight.rotateAngleY = 0.0F;
        wizardLegLeft.rotateAngleY = 0.0F;

        if (wizard.isAttacking())
        {
            this.wizardLeftArm.rotationPointZ = 0.0F;
            this.wizardLeftArm.rotationPointX = 4.0F;
            this.wizardLeftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.wizardLeftArm.rotateAngleZ = -2.3561945F;
            this.wizardLeftArm.rotateAngleY = 0.0F;
            
            this.wizardRightArm.rotationPointZ = 0.0F;
            this.wizardRightArm.rotationPointX = -4.0F;
            this.wizardRightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.wizardRightArm.rotateAngleZ = 2.3561945F;
            this.wizardRightArm.rotateAngleY = 0.0F;
            this.Staff_1.rotateAngleX = 0.0F;
            this.Staff_1.offsetZ = -0.46f;
            this.Staff_1.offsetX = 0f;
            //this.Staff_1.rotateAngleY = -0.4f;
            this.Staff_1.rotateAngleX = -5f;
            this.leftEyebrow.rotateAngleZ = -0.2f;
            this.leftEyebrow.offsetX = 0.05f;
            this.rightEyebrow.rotateAngleZ = 0.2f;
            this.rightEyebrow.offsetX = -0.05f;

        }
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}
}
